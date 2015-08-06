package com.seimos.programacao.manager;

import java.util.Date;

import com.seimos.android.manager.GenericManager;
import com.seimos.programacao.model.Apoio;

/**
 * @author moesio @ gmail.com
 * @date Jul 29, 2015 11:19:02 PM
 */
public interface ApoioManager extends GenericManager<Apoio> {
	public Apoio retrieveDesignacaoSemana(Date data);
}
