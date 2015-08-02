package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.DiscursoPublico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:10:51 AM
 */
public class DiscursoPublicoDaoImpl extends GenericDaoImpl<DiscursoPublico> implements DiscursoPublicoDao {

	public DiscursoPublicoDaoImpl(Context context) {
		super(context);
	}

}
