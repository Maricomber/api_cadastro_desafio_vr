package com.api.cadastro.dtos;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.api.cadastro.enums.TipoPessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

	private int idPessoa;
	
	@NotNull(message = "Campo dataNascimento não pode ficar vazio")
	private Date dataNascimento;
	
	@NotEmpty(message = "Campo nome não pode ficar vazio")
	private String nome;
	
	@NotEmpty(message = "Campo endereco não pode ficar vazio")
	private String endereco;
	
	@NotEmpty(message = "Campo documento não pode ficar vazio")
	private String documento;
	
	@NotNull(message = "Campo tipoPessoa não pode ficar vazio")
	private TipoPessoa tipoPessoa;
	
	private List<TelefoneDTO> telefone;
	private List<CartaoDTO> cartao;
}
