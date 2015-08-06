package com.seimos.android.dao;

import java.util.List;

import com.seimos.android.database.Filter;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 5:43:47 PM
 */
public interface GenericDao<Entity extends com.seimos.android.database.BaseEntity> {
	public abstract boolean create(Entity entity);

	public abstract Entity retrieve(Object id);

	public abstract List<Entity> list();

	public abstract List<Entity> filter(Filter... filters);

	public abstract boolean update(Entity entity);

	public abstract boolean delete(Object id);
}
