package com.seimos.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.seimos.programacao.R;

public class DatabaseHelper extends SQLiteOpenHelper {

	private final Context context;

	public DatabaseHelper(Context context) {
		super(context, context.getString(R.string.app_name), null, Integer.valueOf(context.getString(R.string.database_version)));
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createDb(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String[] versions = context.getResources().getStringArray(R.array.table_upgrade);
		for (int i = oldVersion; i < newVersion; i++) {
			String[] statements = versions[i - 1].split(";");
			for (String statement : statements) {
				db.execSQL(statement);
			}
		}
	}

	private void createDb(SQLiteDatabase db) {
		if (Integer.valueOf(context.getString(R.string.database_version)) == 1) {
			String[] tables = context.getResources().getStringArray(R.array.table_creation);
			for (String table : tables) {
				db.execSQL(table);
			}
		}
	}
}
