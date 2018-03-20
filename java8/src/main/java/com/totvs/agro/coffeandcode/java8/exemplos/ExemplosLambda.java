package com.totvs.agro.coffeandcode.java8.exemplos;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

import com.totvs.agro.coffeandcode.java8.model.FazendaVO;
import com.totvs.agro.coffeandcode.java8.model.TalhaoVO;

public class ExemplosLambda {

	public static void main(String[] args) {
		exemploPredicate();
		exemploConverterTalhaoEmFazenda();
	}

	private static void exemploPredicate() {
		Predicate<TalhaoVO> talhaoPossuiAreaDisponivel = talhao -> !talhao.isSemAreaDisponivel();
		Predicate<TalhaoVO> talhaoPossuiFazenda = talhao -> Objects.nonNull(talhao.getFazenda());
		
		FazendaVO fazenda = new FazendaVO("1", "Fazenda 1");
		TalhaoVO talhao = new TalhaoVO("1", fazenda, BigDecimal.TEN);
		
		boolean talhaoPossuiAreaEFazenda = talhaoPossuiAreaDisponivel
				.and(talhaoPossuiFazenda)
				.test(talhao);
		
		System.out.println(talhaoPossuiAreaEFazenda);
	}

	private static void exemploConverterTalhaoEmFazenda() {
		//Lambda expression que converte TalhaoVO em FazendaVO
		Function<TalhaoVO, FazendaVO> talhaoParaFazenda = talhao -> talhao.getFazenda();
		
		FazendaVO fazenda = new FazendaVO("1", "Fazenda 1");
		TalhaoVO talhao = new TalhaoVO("1", fazenda, BigDecimal.TEN);
		
		FazendaVO fazendaDoTalhao = talhaoParaFazenda.apply(talhao);
		
		System.out.println(fazendaDoTalhao);
	}
}
