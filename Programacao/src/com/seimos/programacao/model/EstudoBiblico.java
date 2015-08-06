package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.BaseEntity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:50:08 PM
 */
public class EstudoBiblico extends BaseEntity {
	@Id
	private Date data;
	private String publicacao;
	private String materia;
	private Pessoa dirigente;
	private Pessoa leitor;

	public Date getData() {
		return data;
	}

	public EstudoBiblico setData(Date data) {
		this.data = data;
		return this;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public EstudoBiblico setPublicacao(String publicacao) {
		this.publicacao = publicacao;
		return this;
	}

	public String getMateria() {
		return materia;
	}

	public EstudoBiblico setMateria(String materia) {
		this.materia = materia;
		return this;
	}

	public Pessoa getDirigente() {
		return dirigente;
	}

	public EstudoBiblico setDirigente(Pessoa dirigente) {
		this.dirigente = dirigente;
		return this;
	}

	public Pessoa getLeitor() {
		return leitor;
	}

	public EstudoBiblico setLeitor(Pessoa leitor) {
		this.leitor = leitor;
		return this;
	}

	@Override
	public String toString() {
		return "EstudoBiblico [data=" + data + ", publicacao=" + publicacao + ", materia=" + materia + ", dirigente=" + dirigente + ", leitor=" + leitor + "]";
	}
}
