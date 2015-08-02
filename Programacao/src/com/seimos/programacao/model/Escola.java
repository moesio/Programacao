package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.Entity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:50:26 PM
 */
public class Escola extends Entity {
	@Id
	public Date data;
	public String destaquesMateria;
	public Pessoa destaquesOrador;
	public String discurso1Materia;
	public Pessoa discurso1Orador;
	public Integer discurso1Estudo;
	public String discurso2Tema;
	public String discurso2Materia;
	public Pessoa discurso2Orador;
	public Pessoa discurso2Ajudante;
	public Integer discurso2Estudo;
	public Integer discurso2Cena;
	public String discurso3Tema;
	public String discurso3Materia;
	public Pessoa discurso3Orador;
	public Pessoa discurso3Ajudante;
	public Integer discurso3Estudo;
	public Integer discurso3Cena;

	public Date getData() {
		return data;
	}

	public Escola setData(Date data) {
		this.data = data;
		return this;
	}

	public String getDestaquesMateria() {
		return destaquesMateria;
	}

	public Escola setDestaquesMateria(String destaquesMateria) {
		this.destaquesMateria = destaquesMateria;
		return this;
	}

	public Pessoa getDestaquesOrador() {
		return destaquesOrador;
	}

	public Escola setDestaquesOrador(Pessoa destaquesOrador) {
		this.destaquesOrador = destaquesOrador;
		return this;
	}

	public String getDiscurso1Materia() {
		return discurso1Materia;
	}

	public Escola setDiscurso1Materia(String discurso1Materia) {
		this.discurso1Materia = discurso1Materia;
		return this;
	}

	public Pessoa getDiscurso1Orador() {
		return discurso1Orador;
	}

	public Escola setDiscurso1Orador(Pessoa discurso1Orador) {
		this.discurso1Orador = discurso1Orador;
		return this;
	}

	public Integer getDiscurso1Estudo() {
		return discurso1Estudo;
	}

	public Escola setDiscurso1Estudo(Integer discurso1Estudo) {
		this.discurso1Estudo = discurso1Estudo;
		return this;
	}

	public String getDiscurso2Tema() {
		return discurso2Tema;
	}

	public Escola setDiscurso2Tema(String discurso2Tema) {
		this.discurso2Tema = discurso2Tema;
		return this;
	}

	public String getDiscurso2Materia() {
		return discurso2Materia;
	}

	public Escola setDiscurso2Materia(String discurso2Materia) {
		this.discurso2Materia = discurso2Materia;
		return this;
	}

	public Pessoa getDiscurso2Orador() {
		return discurso2Orador;
	}

	public Escola setDiscurso2Orador(Pessoa discurso2Orador) {
		this.discurso2Orador = discurso2Orador;
		return this;
	}

	public Pessoa getDiscurso2Ajudante() {
		return discurso2Ajudante;
	}

	public Escola setDiscurso2Ajudante(Pessoa discurso2Ajudante) {
		this.discurso2Ajudante = discurso2Ajudante;
		return this;
	}

	public Integer getDiscurso2Estudo() {
		return discurso2Estudo;
	}

	public Escola setDiscurso2Estudo(Integer discurso2Estudo) {
		this.discurso2Estudo = discurso2Estudo;
		return this;
	}

	public Integer getDiscurso2Cena() {
		return discurso2Cena;
	}

	public Escola setDiscurso2Cena(Integer discurso2Cena) {
		this.discurso2Cena = discurso2Cena;
		return this;
	}

	public String getDiscurso3Tema() {
		return discurso3Tema;
	}

	public Escola setDiscurso3Tema(String discurso3Tema) {
		this.discurso3Tema = discurso3Tema;
		return this;
	}

	public String getDiscurso3Materia() {
		return discurso3Materia;
	}

	public Escola setDiscurso3Materia(String discurso3Materia) {
		this.discurso3Materia = discurso3Materia;
		return this;
	}

	public Pessoa getDiscurso3Orador() {
		return discurso3Orador;
	}

	public Escola setDiscurso3Orador(Pessoa discurso3Orador) {
		this.discurso3Orador = discurso3Orador;
		return this;
	}

	public Pessoa getDiscurso3Ajudante() {
		return discurso3Ajudante;
	}

	public Escola setDiscurso3Ajudante(Pessoa discurso3Ajudante) {
		this.discurso3Ajudante = discurso3Ajudante;
		return this;
	}

	public Integer getDiscurso3Estudo() {
		return discurso3Estudo;
	}

	public Escola setDiscurso3Estudo(Integer discurso3Estudo) {
		this.discurso3Estudo = discurso3Estudo;
		return this;
	}

	public Integer getDiscurso3Cena() {
		return discurso3Cena;
	}

	public Escola setDiscurso3Cena(Integer discurso3Cena) {
		this.discurso3Cena = discurso3Cena;
		return this;
	}

	@Override
	public String toString() {
		return "Escola [data=" + data + ", destaquesMateria=" + destaquesMateria + ", destaquesOrador=" + destaquesOrador + ", discurso1Materia=" + discurso1Materia
				+ ", discurso1Orador=" + discurso1Orador + ", discurso1Estudo=" + discurso1Estudo + ", discurso2Tema=" + discurso2Tema + ", discurso2Materia=" + discurso2Materia
				+ ", discurso2Orador=" + discurso2Orador + ", discurso2Ajudante=" + discurso2Ajudante + ", discurso2Estudo=" + discurso2Estudo + ", discurso2Cena=" + discurso2Cena
				+ ", discurso3Tema=" + discurso3Tema + ", discurso3Materia=" + discurso3Materia + ", discurso3Orador=" + discurso3Orador + ", discurso3Ajudante="
				+ discurso3Ajudante + ", discurso3Estudo=" + discurso3Estudo + ", discurso3Cena=" + discurso3Cena + "]";
	}

}
