package com.seimos.android.dao;

import java.util.List;

import com.seimos.android.database.Filter;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 5:43:47 PM
 */
public interface GenericDao<Entity extends com.seimos.android.database.BaseEntity> {
	boolean create(Entity entity);

	Entity retrieve(Object id);

	List<Entity> list();

	List<Entity> filter(Filter... filters);

	boolean update(Entity entity);

	boolean delete(Object id);

}
