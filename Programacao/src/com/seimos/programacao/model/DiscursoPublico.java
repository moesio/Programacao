package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.Entity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:50:42 PM
 */
public class DiscursoPublico extends Entity {
	@Id
	private Date data;
	private String tema;
	private String orador;
	private String congregacao;
	private Pessoa presidente;

	public Date getData() {
		return data;
	}

	public DiscursoPublico setData(Date data) {
		this.data = data;
		return this;
	}

	public String getTema() {
		return tema;
	}

	public DiscursoPublico setTema(String tema) {
		this.tema = tema;
		return this;
	}

	public String getOrador() {
		return orador;
	}

	public DiscursoPublico setOrador(String orador) {
		this.orador = orador;
		return this;
	}

	public String getCongregacao() {
		return congregacao;
	}

	public DiscursoPublico setCongregacao(String congregacao) {
		this.congregacao = congregacao;
		return this;
	}

	public Pessoa getPresidente() {
		return presidente;
	}

	public DiscursoPublico setPresidente(Pessoa presidente) {
		this.presidente = presidente;
		return this;
	}

	@Override
	public String toString() {
		return "DiscursoPublico [data=" + data + ", tema=" + tema + ", orador=" + orador + ", congregacao=" + congregacao + ", presidente=" + presidente + "]";
	}
}
