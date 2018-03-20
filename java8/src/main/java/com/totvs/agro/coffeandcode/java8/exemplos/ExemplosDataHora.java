package com.totvs.agro.coffeandcode.java8.exemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
		
		/* Objeto com dia, mês e ano */
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataPosterior = dataAtual.plusDays(10L);
		
		/* Objeto com dia, mês, ano e hora */
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		LocalDateTime dataHoraPosterior = dataHoraAtual.plus(5L, ChronoUnit.HOURS);
		
		/* Objeto com dia e mês */
		MonthDay diaMesAtual = MonthDay.now();
		LocalDate diaMesAtualAno2018 = diaMesAtual.atYear(2018);
		
		/* Objeto com ano e mês */
		YearMonth anoMesAtual = YearMonth.now();
		LocalDate finalDoMes = anoMesAtual.atEndOfMonth();
		
		/* Objeto com ano */
		Year anoAtual = Year.now();
		LocalDate natal2018 = anoAtual.atMonthDay(MonthDay.of(12, 25));
	}
}
