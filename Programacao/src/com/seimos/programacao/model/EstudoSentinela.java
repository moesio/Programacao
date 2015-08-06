package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.BaseEntity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:50:53 PM
 */
public class EstudoSentinela extends BaseEntity {
	@Id
	private Date data;
	private String tema;
	private String materia;
	private Pessoa leitor;

	public Date getData() {
		return data;
	}

	public EstudoSentinela setData(Date data) {
		this.data = data;
		return this;
	}

	public String getTema() {
		return tema;
	}

	public EstudoSentinela setTema(String tema) {
		this.tema = tema;
		return this;
	}

	public String getMateria() {
		return materia;
	}

	public EstudoSentinela setMateria(String materia) {
		this.materia = materia;
		return this;
	}

	public Pessoa getLeitor() {
		return leitor;
	}

	public EstudoSentinela setLeitor(Pessoa leitor) {
		this.leitor = leitor;
		return this;
	}

	@Override
	public String toString() {
		return "EstudoSentinela [data=" + data + ", tema=" + tema + ", materia=" + materia + ", leitor=" + leitor + "]";
	}
}
