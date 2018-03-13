package com.totvs.agro.coffeandcode.java8.exemplos;

import java.util.Optional;

import com.totvs.agro.coffeandcode.java8.dao.BrgTalhaoDAO;
import com.totvs.agro.coffeandcode.java8.dao.TalhaoDAO;
import com.totvs.agro.coffeandcode.java8.model.FazendaVO;
import com.totvs.agro.coffeandcode.java8.model.TalhaoVO;

public class ExemplosOptional {

	private static TalhaoDAO talhaoDAO = new TalhaoDAO();
	private static BrgTalhaoDAO brgTalhaoDAO = new BrgTalhaoDAO();

	public static void insertTalhaoAlteradoTabelaIntegracaoSemOptional() {
		TalhaoVO talhaoAlterado = talhaoDAO.selectTalhaoAlteradoSemOptional();
		if (talhaoAlterado != null && talhaoAlterado.getId() != null && talhaoAlterado.getId() != 0L) {
			brgTalhaoDAO.insertTalhaoIntegracao(talhaoAlterado);
		}
	}

	public static void insertTalhaoAlteradoTabelaIntegracaoComOptional() {
		talhaoDAO.selectTalhaoAlterado().ifPresent(brgTalhaoDAO::insertTalhaoIntegracao);
	}

	public static String getCodigoFazendaDoTalhaoComOptional(TalhaoVO talhao) {
		return Optional.ofNullable(talhao)
				.map(TalhaoVO::getFazenda)
				.map(FazendaVO::getCodigo)
				.orElse("");
	}

	public static String getCodigoFazendaDoTalhaoSemOptional(TalhaoVO talhao) {
		// code smell
		if (talhao != null && talhao.getFazenda() != null) {
			return talhao.getFazenda().getCodigo() != null ? talhao.getFazenda().getCodigo() : "";
		}
		return "";
	}
}
