package com.seimos.programacao.db;

import java.util.Date;

/**
 * @author moesio @ gmail.com
 * @date Jul 13, 2015 11:24:27 PM
 */
public class Dao {
	public enum Field {
		LIMPEZA, INDICADOR, SOM, PALCO, VOLANTE1, VOLANTE2, ESTUDO_BIBLICO_PUBLICACAO, ESTUDO_BIBLICO_MATERIA, ESTUDO_BIBLICO_DIRIGENTE, ESTUDO_BIBLICO_LEITOR,
		ESCOLA_DESTAQUES_MATERIA, ESCOLA_DESTAQUES_ORADOR, ESCOLA_DISCURSO1_MATERIA, ESCOLA_DISCURSO1_ORADOR, ESCOLA_DISCURSO2_TEMA, ESCOLA_DISCURSO2_MATERIA,
		ESCOLA_DISCURSO2_ORADOR, ESCOLA_DISCURSO2_AJUDANTE, ESCOLA_DISCURSO3_TEMA, ESCOLA_DISCURSO3_MATERIA, ESCOLA_DISCURSO3_ORADOR, ESCOLA_DISCURSO3_AJUDANTE,
		REUNIAO_SERVICO_PARTE1_TEMA, REUNIAO_SERVICO_PARTE1_ORADOR, REUNIAO_SERVICO_PARTE2_TEMA, REUNIAO_SERVICO_PARTE2_ORADOR, REUNIAO_SERVICO_PARTE3_TEMA,
		REUNIAO_SERVICO_PARTE3_ORADOR, REUNIAO_SERVICO_ORACAO_FINAL, DISCURSO_PUBLICO_TEMA, DISCURSO_PUBLICO_ORADOR, DISCURSO_PUBLICO_CONGREGACAO, DISCURSO_PUBLICO_PRESIDENTE,
		ESTUDO_SENTINELA_TEMA, ESTUDO_SENTINELA_MATERIA, ESTUDO_SENTINELA_LEITOR

	};

	public static String get(Field field, Date date) {
		String result = "";
		switch (field) {
		case LIMPEZA:
			result = "Grupo 1";
			break;
		case INDICADOR:
			result = "Januário José";
			break;
		case SOM:
			result = "Kende Paula";
			break;
		case PALCO:
			result = "Regilson Freitas";
			break;
		case VOLANTE1:
			result = "Antonio Martins";
			break;
		case VOLANTE2:
			result = "Robson Martins";
			break;
		case ESTUDO_BIBLICO_PUBLICACAO:
			result = "Achegue-se a Jeová";
			break;
		case ESTUDO_BIBLICO_MATERIA:
			result = "cl cap. 27 $$ 1-9";
			break;
		case ESTUDO_BIBLICO_DIRIGENTE:
			result = "Francisco Viana";
			break;
		case ESTUDO_BIBLICO_LEITOR:
			result = "Leonardo Araújo";
			break;
		case ESCOLA_DESTAQUES_MATERIA:
			result = "1 Reis 7-8";
			break;
		case ESCOLA_DESTAQUES_ORADOR:
			result = "Marcos Éber";
			break;
		case ESCOLA_DISCURSO1_MATERIA:
			result = "1 Reis 8:27-34";
			break;
		case ESCOLA_DISCURSO1_ORADOR:
			result = "Januário José";
			break;
		case ESCOLA_DISCURSO2_TEMA:
			result = "Cornélio - Tema: Jeová Deus não é parcial";
			break;
		case ESCOLA_DISCURSO2_MATERIA:
			result = "it-1 pp. 567-568";
			break;
		case ESCOLA_DISCURSO2_ORADOR:
			result = "Jordana Ribeiro";
			break;
		case ESCOLA_DISCURSO2_AJUDANTE:
			result = "Valdenice Souza";
			break;
		case ESCOLA_DISCURSO3_TEMA:
			result = "Como lidar com a ansiedade?";
			break;
		case ESCOLA_DISCURSO3_MATERIA:
			result = "igw p. 24 pars 1-3";
			break;
		case ESCOLA_DISCURSO3_ORADOR:
			result = "Moésio Medeiros";
			break;
		case ESCOLA_DISCURSO3_AJUDANTE:
			result = "Airton Santos";
			break;
		case REUNIAO_SERVICO_PARTE1_TEMA:
			result = "Ofereça as revistas em julho";
			break;
		case REUNIAO_SERVICO_PARTE1_ORADOR:
			result = "Aurélio Ribeiro";
			break;
		case REUNIAO_SERVICO_PARTE2_TEMA:
			result = "Necessidades locais";
			break;
		case REUNIAO_SERVICO_PARTE2_ORADOR:
			result = "Airton França";
			break;
		case REUNIAO_SERVICO_PARTE3_TEMA:
			result = "Como nos saímos?";
			break;
		case REUNIAO_SERVICO_PARTE3_ORADOR:
			result = "Moésio Medeiros";
			break;
		case REUNIAO_SERVICO_ORACAO_FINAL:
			result = "Moésio Medeiros";
			break;
		case DISCURSO_PUBLICO_TEMA:
			result = "Desvie seus olhos do que é fútil";
			break;
		case DISCURSO_PUBLICO_ORADOR:
			result = "Alex Leal";
			break;
		case DISCURSO_PUBLICO_CONGREGACAO:
			result = "Praia do Futuro";
			break;
		case DISCURSO_PUBLICO_PRESIDENTE:
			result = "Ocivan Santiago";
			break;
		case ESTUDO_SENTINELA_TEMA:
			result = "Lute contra Satanás - e vença!";
			break;
		case ESTUDO_SENTINELA_MATERIA:
			result = "w15 15/5 pp. 14-18";
			break;
		case ESTUDO_SENTINELA_LEITOR:
			result = "Moésio Medeiros";
			break;
		}

		return result;
	}
}
