package com.seimos.programacao.ui;

import android.content.Context;

import com.seimos.programacao.R;

/**
 * @author moesio @ gmail.com
 * @date Aug 8, 2015 2:39:36 PM
 */
public class MenuPrincipal {

	public static int getSection(int number) {
		int sectionResource = 0;
		switch (number) {
		case 1:
			sectionResource = R.string.section_participacao;
			break;
		case 2:
			sectionResource = R.string.section_apoio;
			break;
		case 3:
			sectionResource = R.string.section_estudo_biblico;
			break;
		case 4:
			sectionResource = R.string.section_escola;
			break;
		case 5:
			sectionResource = R.string.section_servico;
			break;
		case 6:
			sectionResource = R.string.section_discurso;
			break;
		case 7:
			sectionResource = R.string.section_estudo_sentinela;
			break;
		case 8:
			sectionResource = R.string.section_cadastrar;
			break;
		case 9:
			sectionResource = R.string.section_criar_programacao;
			break;
		}
		return sectionResource;
	}

	public static String[] getItems(Context context) {
		String[] items = new String[] {
				context.getString(R.string.section_participacao),
				context.getString(R.string.section_apoio),
				context.getString(R.string.section_estudo_biblico),
				context.getString(R.string.section_escola),
				context.getString(R.string.section_servico),
				context.getString(R.string.section_discurso),
				context.getString(R.string.section_estudo_sentinela),
				context.getString(R.string.section_cadastrar),
				context.getString(R.string.section_criar_programacao) };
		return items;
	}
}
