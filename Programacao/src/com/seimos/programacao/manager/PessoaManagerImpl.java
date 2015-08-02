package com.seimos.programacao.manager;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.PessoaDao;
import com.seimos.programacao.dao.PessoaDaoImpl;
import com.seimos.programacao.model.Pessoa;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 6:09:26 PM
 */
public class PessoaManagerImpl extends GenericManagerImpl<Pessoa, PessoaDao> implements PessoaManager {

	private PessoaDaoImpl dao;

	public PessoaManagerImpl(Context context) {
		super(context);
		this.dao = new PessoaDaoImpl(context);
	}

	@Override
	public GenericDao<Pessoa> getDao() {
		return dao;
	}
}
