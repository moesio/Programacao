package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.EscolaDao;
import com.seimos.programacao.dao.EscolaDaoImpl;
import com.seimos.programacao.model.Escola;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:16:25 AM
 */
public class EscolaManagerImpl extends GenericManagerImpl<Escola, EscolaDao> implements EscolaManager {

	private GenericDao<Escola> dao;

	public EscolaManagerImpl(Context context) {
		super(context);
		this.dao = new EscolaDaoImpl(context);
	}

	@Override
	public GenericDao<Escola> getDao() {
		return dao;
	}

}
