package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.ApoioDao;
import com.seimos.programacao.dao.ApoioDaoImpl;
import com.seimos.programacao.model.Apoio;

/**
 * @author moesio @ gmail.com
 * @date Jul 29, 2015 11:19:55 PM
 */
public class ApoioManagerImpl extends GenericManagerImpl<Apoio, ApoioDao> implements ApoioManager {

	private ApoioDaoImpl dao;

	public ApoioManagerImpl(Context context) {
		super(context);
		this.dao = new ApoioDaoImpl(context);
	}

	@Override
	public GenericDao<Apoio> getDao() {
		return dao;
	}
}
