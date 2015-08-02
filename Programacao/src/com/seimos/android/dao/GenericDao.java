package com.seimos.android.dao;

import java.util.List;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 5:43:47 PM
 */
public interface GenericDao<Entity extends com.seimos.android.database.Entity> {
	public abstract boolean create(Entity entity);

	public abstract Entity retrieve(Object id);

	public abstract List<Entity> list();

	public abstract boolean update(Entity entity);

	public abstract boolean delete(Object id);
}
