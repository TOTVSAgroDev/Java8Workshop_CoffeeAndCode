package com.totvs.agro.coffeandcode.java8.model;

import java.time.LocalDate;

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
}
