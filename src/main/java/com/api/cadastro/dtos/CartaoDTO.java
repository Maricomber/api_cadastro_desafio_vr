package com.api.cadastro.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@NotEmpty(message = "Campo numero não pode ficar vazio")
	private String numero;
	
	@NotNull(message = "Campo dataVencimento não pode ficar vazio")
	private Date dataVencimento;
	
	@NotNull(message = "Campo dataEmissao não pode ficar vazio")
	private Date dataEmissao;
	
	@NotEmpty(message = "Campo codSeguranca não pode ficar vazio")
	private String codSeguranca;
	
	@NotEmpty
	private TipoCartao tipoCartao;
	
	@NotNull(message = "Campo saldo não pode ficar vazio")
	private float saldo;
	
	@NotNull(message = "Campo isAtivo não pode ficar vazio")
	private Boolean isAtivo;
	
	@NotNull(message = "Campo idPessoa não pode ficar vazio")
	private int idPessoa;
}
