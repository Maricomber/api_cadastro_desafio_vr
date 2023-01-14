package com.api.cadastro.dtos;

import java.util.Date;

import com.api.cadastro.enums.TipoCartao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {

	private Integer idCartao;
	private String numero;
	private Date dataVencimento;
	private Date dataEmissao;
	private String codSeguranca;
	private TipoCartao tipoCartao;
	private float saldo;
	private Boolean isAtivo;
	private int idPessoa;
}
