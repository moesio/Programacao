package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.EstudoSentinelaDao;
import com.seimos.programacao.dao.EstudoSentinelaDaoImpl;
import com.seimos.programacao.model.EstudoSentinela;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:22:49 AM
 */
public class EstudoSentinelaManagerImpl extends GenericManagerImpl<EstudoSentinela, EstudoSentinelaDao> implements EstudoSentinelaManager {

	private GenericDao<EstudoSentinela> dao;

	public EstudoSentinelaManagerImpl(Context context) {
		super(context);
		this.dao = new EstudoSentinelaDaoImpl(context);
	}

	@Override
	public GenericDao<EstudoSentinela> getDao() {
		return dao;
	}

}
