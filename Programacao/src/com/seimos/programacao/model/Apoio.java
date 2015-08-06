package com.seimos.programacao.model;

import java.util.Date;

import com.seimos.android.annotation.Id;
import com.seimos.android.database.BaseEntity;

/**
 * @author moesio @ gmail.com
 * @date Jul 16, 2015 11:49:58 PM
 */
public class Apoio extends BaseEntity {
	@Id
	private Date data;
	private Integer limpeza;
	private Pessoa indicador;
	private Pessoa som;
	private Pessoa palco;
	private Pessoa volante1;
	private Pessoa volante2;

	public Date getData() {
		return data;
	}

	public Apoio setData(Date date) {
		this.data = date;
		return this;
	}

	public Integer getLimpeza() {
		return limpeza;
	}

	public Apoio setLimpeza(Integer limpeza) {
		this.limpeza = limpeza;
		return this;
	}

	public Pessoa getIndicador() {
		return indicador;
	}

	public Apoio setIndicador(Pessoa indicador) {
		this.indicador = indicador;
		return this;
	}

	public Pessoa getSom() {
		return som;
	}

	public Apoio setSom(Pessoa som) {
		this.som = som;
		return this;
	}

	public Pessoa getPalco() {
		return palco;
	}

	public Apoio setPalco(Pessoa palco) {
		this.palco = palco;
		return this;
	}

	public Pessoa getVolante1() {
		return volante1;
	}

	public Apoio setVolante1(Pessoa volante1) {
		this.volante1 = volante1;
		return this;
	}

	public Pessoa getVolante2() {
		return volante2;
	}

	public Apoio setVolante2(Pessoa volante2) {
		this.volante2 = volante2;
		return this;
	}

	@Override
	public String toString() {
		return "Apoio [data=" + data + ", limpeza=" + limpeza + ", indicador=" + indicador + ", som=" + som + ", palco=" + palco + ", volante1=" + volante1 + ", volante2="
				+ volante2 + "]";
	}

}
