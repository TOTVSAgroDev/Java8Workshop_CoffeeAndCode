package com.totvs.agro.coffeandcode.java8.exemplos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.totvs.agro.coffeandcode.java8.model.AplicacaoInsumoVO;
import com.totvs.agro.coffeandcode.java8.model.TalhaoVO;

public class ExemplosMaps {

	static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO_SEM_LAMBDA = new Function<TalhaoVO, Long>() {
		public Long apply(TalhaoVO upn3) {
			return upn3.getId();
		}
	};

	static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO_LAMBDA = talhao -> talhao.getId();

	static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO = TalhaoVO::getId;

	public static Map<TalhaoVO, BigDecimal> agruparAreasApontadasPorTalhoes(Collection<AplicacaoInsumoVO> apontamentos) {
		Map<TalhaoVO, BigDecimal> areasApontamentosPorTalhao = new HashMap<>();

		for (AplicacaoInsumoVO aplicacaoInsumo : apontamentos) {
			areasApontamentosPorTalhao.merge(
					aplicacaoInsumo.getTalhao(), 
					aplicacaoInsumo.getAreaAplicada(),
					BigDecimal::add);
		}

		return areasApontamentosPorTalhao;
	}
	
	public static Map<TalhaoVO, BigDecimal> agruparAreasApontadasPorTalhoesUtilizandoCompute(Collection<AplicacaoInsumoVO> apontamentos) {
		Map<TalhaoVO, BigDecimal> areasApontamentosPorTalhao = new HashMap<>();

		for (AplicacaoInsumoVO aplicacaoInsumo : apontamentos) {
			areasApontamentosPorTalhao.compute(aplicacaoInsumo.getTalhao(),
					(talhao, area) -> {
						BigDecimal areaAplicada = aplicacaoInsumo.getAreaAplicada();
						return area == null ? areaAplicada : area.add(areaAplicada);
					});
		}

		return areasApontamentosPorTalhao;
	}

	public static void main(String[] args) {
		List<AplicacaoInsumoVO> apontamentos = Lists.newArrayList(
				gerarAplicacaoInsumo(1L, "1", new BigDecimal("50")),
				gerarAplicacaoInsumo(2L, "1", new BigDecimal("50")),
				gerarAplicacaoInsumo(3L, "2", new BigDecimal("80")));
		
		Map<TalhaoVO, BigDecimal> areasAgrupadas = agruparAreasApontadasPorTalhoes(apontamentos);
		System.out.println(areasAgrupadas);
	}

	private static AplicacaoInsumoVO gerarAplicacaoInsumo(Long numero, String codigoTalhao, BigDecimal AreaAplicada) {
		AplicacaoInsumoVO vo = new AplicacaoInsumoVO();
		vo.setId(numero);
		vo.setAreaAplicada(AreaAplicada);
		vo.setDataOperacao(LocalDate.now());
		vo.setNumeroBoletim(1L);
		vo.setTalhao(new TalhaoVO(codigoTalhao, null, null));
		return vo;
	}
}
