package com.seimos.programacao.model;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.BaseEntity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:49:51 PM
 */
public class Pessoa extends BaseEntity {
	@Id
	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public Pessoa setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Pessoa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

}
