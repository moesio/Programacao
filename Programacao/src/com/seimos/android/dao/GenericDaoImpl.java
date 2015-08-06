package com.seimos.android.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.seimos.android.database.BaseEntity;
import com.seimos.android.database.DatabaseUtil;
import com.seimos.android.database.Filter;
import com.seimos.android.database.FilterManager;
import com.seimos.android.util.Reflection;
import com.seimos.programacao.R;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 5:47:59 PM
 */
public abstract class GenericDaoImpl<Entity extends BaseEntity> implements GenericDao<Entity> {

	private Context context;
	private Class<Entity> entityClass;

	@SuppressWarnings("unused")
	private GenericDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl(Context context) {
		this.context = context;
		this.entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private String getTableName() {
		return toDatabaseName(entityClass.getSimpleName());
	}

	private String[] getColumns() {
		Field[] fields = entityClass.getDeclaredFields();
		String[] columns = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			columns[i] = toDatabaseName(fields[i].getName());
		}
		return columns;
	}

	private ContentValues createContentValues(Entity entity) {
		ContentValues values = new ContentValues();

		Field[] declaredFields = entity.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			Object invoke = Reflection.invoke(entity, field.getName());
			String databaseFieldName = toDatabaseName(field.getName());
			if (invoke != null) {
				if (Reflection.isEntity(invoke)) {
					Field idField = Reflection.getIdField(field.getType());
					values.put(databaseFieldName, (Integer) Reflection.invoke(invoke, idField.getName()));
				} else if (field.getType() == Integer.class) {
					values.put(databaseFieldName, (Integer) invoke);
				} else if (field.getType() == Boolean.class) {
					values.put(databaseFieldName, (Boolean) invoke);
				} else if (field.getType() == Date.class) {
					values.put(databaseFieldName, Filter.getStringValue(invoke));
				} else {
					values.put(databaseFieldName, (String) invoke);
				}
			}
		}
		return values;
	}

	private String toDatabaseName(String name) {
		return name.replaceAll("(\\W)", "_$1");
	}

	private List<Entity> extract(Cursor cursor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		List<Entity> list = new ArrayList<Entity>();
		if (cursor.moveToFirst()) {
			do {
				list.add(createEntityFromCursor(cursor));
			} while (cursor.moveToNext());
		} else {
			list = Collections.emptyList();
		}
		return (List<Entity>) list;
	}

	@SuppressLint("SimpleDateFormat")
	private Entity createEntityFromCursor(Cursor cursor) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Entity entity = entityClass.newInstance();
		String[] columnNames = cursor.getColumnNames();
		for (String columnName : columnNames) {
			try {
				Field field = entityClass.getDeclaredField(columnName);
				Class<?> type = field.getType();
				Method method = entityClass.getMethod(Reflection.getSetter(columnName), type);

				if (type == Boolean.class) {
					method.invoke(entity, cursor.getInt(cursor.getColumnIndex(columnName)));
				} else if (type == Integer.class) {
					method.invoke(entity, cursor.getInt(cursor.getColumnIndex(columnName)));
				} else if (type == String.class) {
					method.invoke(entity, cursor.getString(cursor.getColumnIndex(columnName)));
				} else if (type == Date.class) {
					String value = cursor.getString(cursor.getColumnIndex(columnName));
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-MM-dd").parse(value);
					} catch (ParseException e) {
					}
					method.invoke(entity, date);
				} else {
					com.seimos.android.database.BaseEntity association = (com.seimos.android.database.BaseEntity) type.newInstance();
					Method methodAssociation = association.getClass().getMethod(Reflection.getSetter(Reflection.getIdField(association.getClass()).getName()), Integer.class);
					methodAssociation.invoke(association, cursor.getInt(cursor.getColumnIndex(columnName)));
					method.invoke(entity, association);

				}
			} catch (NoSuchFieldException e) {
			}
		}
		return entity;
	}

	public boolean create(Entity entity) {
		SQLiteDatabase database = DatabaseUtil.openForRead(context);
		ContentValues values = createContentValues(entity);
		long id = database.insert(getTableName(), null, values);
		database.close();
		return id != 0;
	}

	public Entity retrieve(Object id) {
		SQLiteDatabase database = DatabaseUtil.openForRead(context);
		List<Entity> list = new ArrayList<Entity>();
		Cursor cursor;
		try {
			Field idField = Reflection.getIdField(entityClass);
			String idValue = Filter.getStringValue(id);
			String idFieldName = idField.getName();
			cursor = database.query(getTableName(), getColumns(), idFieldName + " = ?", new String[] { idValue }, null, null, idFieldName, "1");
			list = extract(cursor);
		} catch (Exception e) {
			Log.e(context.getString(R.string.app_name), "Erro no banco!");
		}
		database.close();
		try {
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public List<Entity> list() {
		return filter();
	}

	public List<Entity> filter(Filter... filters) {
		SQLiteDatabase database = DatabaseUtil.openForRead(context);
		List<Entity> list = new ArrayList<Entity>();
		Cursor cursor;
		try {
			cursor = database.query(getTableName(), getColumns(), FilterManager.getSelection(filters), FilterManager.getArgs(filters), null, null, null);
			list = extract(cursor);
		} catch (Exception e) {
			Log.e(context.getString(R.string.app_name), "Erro na criação da lista!");
		}
		database.close();
		return (List<Entity>) list;
	}

	public boolean update(Entity entity) {
		SQLiteDatabase database = DatabaseUtil.openForWrite(context);
		ContentValues values = createContentValues(entity);
		try {
			Field idField = Reflection.getIdField(entityClass);
			Method method = entityClass.getMethod(Reflection.getGetter(idField));
			int affectedRows = database.update(getTableName(), values, "id = ?", new String[] { method.invoke(entity).toString() });
			return affectedRows != 0;
		} catch (Exception e) {
			return false;
		} finally {
			database.close();
		}
	}

	public boolean delete(Object id) {
		SQLiteDatabase database = DatabaseUtil.openForWrite(context);
		int affectedRows = database.delete(getTableName(), "id = ?", new String[] { id.toString() });
		database.close();
		return affectedRows > 0;
	}

}
