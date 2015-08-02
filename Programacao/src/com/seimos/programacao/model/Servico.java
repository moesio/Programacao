package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.Entity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:50:31 PM
 */
public class Servico extends Entity {
	@Id
	private Date data;
	private String parte1Tema;
	private Pessoa parte1Orador;
	private String parte2Tema;
	private Pessoa parte2Orador;
	private String parte3Tema;
	private Pessoa parte3Orador;
	private Pessoa oracao;

	public Date getData() {
		return data;
	}

	public Servico setData(Date data) {
		this.data = data;
		return this;
	}

	public String getParte1Tema() {
		return parte1Tema;
	}

	public Servico setParte1Tema(String parte1Tema) {
		this.parte1Tema = parte1Tema;
		return this;
	}

	public Pessoa getParte1Orador() {
		return parte1Orador;
	}

	public Servico setParte1Orador(Pessoa parte1Orador) {
		this.parte1Orador = parte1Orador;
		return this;
	}

	public String getParte2Tema() {
		return parte2Tema;
	}

	public Servico setParte2Tema(String parte2Tema) {
		this.parte2Tema = parte2Tema;
		return this;
	}

	public Pessoa getParte2Orador() {
		return parte2Orador;
	}

	public Servico setParte2Orador(Pessoa parte2Orador) {
		this.parte2Orador = parte2Orador;
		return this;
	}

	public String getParte3Tema() {
		return parte3Tema;
	}

	public Servico setParte3Tema(String parte3Tema) {
		this.parte3Tema = parte3Tema;
		return this;
	}

	public Pessoa getParte3Orador() {
		return parte3Orador;
	}

	public Servico setParte3Orador(Pessoa parte3Orador) {
		this.parte3Orador = parte3Orador;
		return this;
	}

	public Pessoa getOracao() {
		return oracao;
	}

	public Servico setOracao(Pessoa oracao) {
		this.oracao = oracao;
		return this;
	}

	@Override
	public String toString() {
		return "Servico [data=" + data + ", parte1Tema=" + parte1Tema + ", parte1Orador=" + parte1Orador + ", parte2Tema=" + parte2Tema + ", parte2Orador=" + parte2Orador
				+ ", parte3Tema=" + parte3Tema + ", parte3Orador=" + parte3Orador + ", oracao=" + oracao + "]";
	}
}
