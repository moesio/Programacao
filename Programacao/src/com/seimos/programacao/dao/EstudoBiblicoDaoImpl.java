package com.seimos.programacao.dao;

import android.content.Context;

import com.seimos.android.dao.GenericDaoImpl;
import com.seimos.programacao.model.EstudoBiblico;

/**
 * @author moesio @ gmail.com
 * @date Jul 30, 2015 11:18:25 AM
 */
public class EstudoBiblicoDaoImpl extends GenericDaoImpl<EstudoBiblico> implements EstudoBiblicoDao {

	public EstudoBiblicoDaoImpl(Context context) {
		super(context);
	}

}
