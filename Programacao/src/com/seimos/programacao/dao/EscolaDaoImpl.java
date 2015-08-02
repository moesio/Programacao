package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.Escola;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:14:55 AM
 */
public class EscolaDaoImpl extends GenericDaoImpl<Escola> implements EscolaDao {

	public EscolaDaoImpl(Context context) {
		super(context);
	}

}
