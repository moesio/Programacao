package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.ServicoDao;
import com.seimos.programacao.dao.ServicoDaoImpl;
import com.seimos.programacao.model.Servico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:25:17 AM
 */
public class ServicoManagerImpl extends GenericManagerImpl<Servico, ServicoDao> {

	private GenericDao<Servico> dao;

	public ServicoManagerImpl(Context context) {
		super(context);
		this.dao = new ServicoDaoImpl(context);
	}

	@Override
	public GenericDao<Servico> getDao() {
		return dao;
	}

}
