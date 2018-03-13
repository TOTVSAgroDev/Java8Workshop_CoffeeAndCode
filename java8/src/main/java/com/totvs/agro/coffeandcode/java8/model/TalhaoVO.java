package com.totvs.agro.coffeandcode.java8.model;

import java.math.BigDecimal;

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
public class TalhaoVO extends AbstractVO {

	private String codigo;
	private FazendaVO fazenda;
	private BigDecimal area;
	
	public boolean isSemAreaDisponivel() {
		return area == null || area.compareTo(BigDecimal.ZERO) <= 0;
	}
}
