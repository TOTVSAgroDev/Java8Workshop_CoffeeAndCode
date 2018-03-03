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
@EqualsAndHashCode(of = {"fazenda", "codigo"}, callSuper = false)
public class TalhaoVO {

	private String codigo;
	private FazendaVO fazenda;
}
