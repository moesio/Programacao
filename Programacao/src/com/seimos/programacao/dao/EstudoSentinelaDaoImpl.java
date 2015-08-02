package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.EstudoSentinela;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:21:40 AM
 */
public class EstudoSentinelaDaoImpl extends GenericDaoImpl<EstudoSentinela> implements EstudoSentinelaDao {

	public EstudoSentinelaDaoImpl(Context context) {
		super(context);
	}

}
