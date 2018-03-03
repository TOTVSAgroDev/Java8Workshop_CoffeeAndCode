package com.totvs.agro.coffeandcode.java8.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo", callSuper = false)
public class FazendaVO extends AbstractVO {

	private String codigo;
	private String descricao;
}
