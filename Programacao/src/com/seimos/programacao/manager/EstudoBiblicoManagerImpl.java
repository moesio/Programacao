package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.EstudoBiblicoDao;
import com.seimos.programacao.dao.EstudoBiblicoDaoImpl;
import com.seimos.programacao.model.EstudoBiblico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:19:50 AM
 */
public class EstudoBiblicoManagerImpl extends GenericManagerImpl<EstudoBiblico, EstudoBiblicoDao> implements EstudoBiblicoManager {

	private GenericDao<EstudoBiblico> dao;

	public EstudoBiblicoManagerImpl(Context context) {
		super(context);
		this.dao = new EstudoBiblicoDaoImpl(context);
	}

	@Override
	public GenericDao<EstudoBiblico> getDao() {
		return dao;
	}

}
