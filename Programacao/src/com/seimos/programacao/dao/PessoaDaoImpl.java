package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.Pessoa;

/**
 * @author moesio @ gmail.com
 * @date Jul 28, 2015 6:07:47 PM
 */
public class PessoaDaoImpl extends GenericDaoImpl<Pessoa> implements PessoaDao {

	public PessoaDaoImpl(Context context) {
		super(context);
	}
}
