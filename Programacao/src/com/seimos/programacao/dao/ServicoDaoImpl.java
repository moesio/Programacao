package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.Servico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:24:27 AM
 */
public class ServicoDaoImpl extends GenericDaoImpl<Servico> implements ServicoDao {

	public ServicoDaoImpl(Context context) {
		super(context);
	}

}
