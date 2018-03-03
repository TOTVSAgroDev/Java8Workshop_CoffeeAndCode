package com.totvs.agro.coffeandcode.java8.exemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.totvs.agro.coffeandcode.java8.model.AplicacaoInsumoVO;

public class ExemplosDataHora {

	private static long DIAS_APOS_APLICACAO_PERMITIDO_COLHER = 120L;

	public boolean isDataColheitaPermitidaAposAplicacaoInsumos(
			AplicacaoInsumoVO aplicacaoInsumos,
			LocalDate dataColheita) {

		LocalDate dataLimite = aplicacaoInsumos.getDataOperacao()
				.plusDays(DIAS_APOS_APLICACAO_PERMITIDO_COLHER);

		return dataColheita.isAfter(dataLimite);
	}

	public static void main(String[] args) {
		String dataHora = LocalDate
				.of(2018, 1, 1)
				.atStartOfDay()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
				.toString();

		System.out.println(dataHora);
	}
}
