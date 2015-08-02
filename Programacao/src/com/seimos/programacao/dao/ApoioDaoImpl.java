package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.Apoio;

/**
 * @author moesio @ gmail.com
 * @date Jul 29, 2015 11:18:30 PM
 */
public class ApoioDaoImpl extends GenericDaoImpl<Apoio> implements ApoioDao {

	public ApoioDaoImpl(Context context) {
		super(context);
	}

}
