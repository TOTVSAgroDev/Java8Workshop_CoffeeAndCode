package com.totvs.agro.coffeandcode.java8.exemplos;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.totvs.agro.coffeandcode.java8.model.AplicacaoInsumoVO;
import com.totvs.agro.coffeandcode.java8.model.TalhaoVO;

public class ExemplosStream {

	public static boolean isAlgumTalhaoSemAreaDisponivel(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream().anyMatch(apontamento -> apontamento.getTalhao().isSemAreaDisponivel());
	}
	
	public static boolean isNenhumTalhaoSemAreaDisponivel(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream().noneMatch(apontamento -> apontamento.getTalhao().isSemAreaDisponivel());
	}
	
	public static boolean isTodosTalhoesSemAreaDisponivel(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream().allMatch(apontamento -> apontamento.getTalhao().isSemAreaDisponivel());
	}
	
	public static Map<TalhaoVO, BigDecimal> agruparAreasApontadasPorTalhoes(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream()
				.collect(Collectors.toMap(AplicacaoInsumoVO::getTalhao, AplicacaoInsumoVO::getAreaAplicada));
	}
	
	public static BigDecimal getSomaAreasApontadasPorTalhao(Collection<AplicacaoInsumoVO> apontamentos, TalhaoVO talhao) {
		return apontamentos.stream()
				.filter(apontamento -> apontamento.getTalhao().equals(talhao))
				.map(AplicacaoInsumoVO::getAreaAplicada)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
	public static Map<LocalDate, List<AplicacaoInsumoVO>> agruparApontamentosPorData(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream()
				.collect(Collectors.groupingBy(AplicacaoInsumoVO::getDataOperacao));
	}
	
	public static Map<LocalDate, List<AplicacaoInsumoVO>> agruparApontamentosPorDataFiltrandoTalhao(Collection<AplicacaoInsumoVO> apontamentos, TalhaoVO talhao) {
		return apontamentos.stream()
				.filter(apontamento -> apontamento.getTalhao().equals(talhao))
				.collect(Collectors.groupingBy(AplicacaoInsumoVO::getDataOperacao));
	}
	
	public static Map<LocalDate, Long> contarApontamentosPorData(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream()
				.collect(Collectors.groupingBy(AplicacaoInsumoVO::getDataOperacao, Collectors.counting()));
	}
	
	public static Map<LocalDate, Double> agruparMediaAreaAplicadaPorData(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream()
				.collect(groupingBy(AplicacaoInsumoVO::getDataOperacao, averagingDouble(AplicacaoInsumoVO::getAreaAplicadaAsDouble)));
	}
	
	public static Double getMaiorAreaAplicada(Collection<AplicacaoInsumoVO> apontamentos) {
		return apontamentos.stream()
				.mapToDouble(AplicacaoInsumoVO::getAreaAplicadaAsDouble)
				.max()
				.orElse(0d);
	}

}
