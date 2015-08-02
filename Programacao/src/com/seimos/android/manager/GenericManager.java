package com.seimos.android.manager;

import java.util.List;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 5:39:36 PM
 */
public interface GenericManager<Entity> {
	public abstract boolean create(Entity entity);

	public abstract Entity retrieve(Object id);

	public abstract List<Entity> list();

	public abstract boolean update(Entity entity);

	public abstract boolean delete(Object id);
}
