package com.totvs.agro.coffeandcode.java8.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.google.common.primitives.Doubles;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "numeroBoletim", callSuper = false)
public class AplicacaoInsumoVO extends AbstractVO implements BoletimCampo {

	private Long numeroBoletim;
	private LocalDate dataOperacao;
	private TalhaoVO talhao;
	private BigDecimal areaAplicada;
	
	public double getAreaAplicadaAsDouble() {
		return Optional.ofNullable(areaAplicada)
					.map(BigDecimal::toString)
					.map(Doubles::tryParse)
					.orElse(0D);
	}
}
