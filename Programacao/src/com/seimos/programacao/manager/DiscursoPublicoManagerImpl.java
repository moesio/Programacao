package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.DiscursoPublicoDao;
import com.seimos.programacao.dao.DiscursoPublicoDaoImpl;
import com.seimos.programacao.model.DiscursoPublico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:12:22 AM
 */
public class DiscursoPublicoManagerImpl extends GenericManagerImpl<DiscursoPublico, DiscursoPublicoDao> implements DiscursoPublicoManager {

	private GenericDao<DiscursoPublico> dao;

	public DiscursoPublicoManagerImpl(Context context) {
		super(context);
		this.dao = new DiscursoPublicoDaoImpl(context);
	}

	@Override
	public GenericDao<DiscursoPublico> getDao() {
		return dao;
	}

}
