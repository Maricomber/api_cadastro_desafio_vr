package com.api.cartao.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {

	private Integer id;
	private String numero;
	private Date dataVencimento;
	private Date dataEmissao;
	private String codSeguranca;
	private float saldo;
	private int idPessoa;
}
