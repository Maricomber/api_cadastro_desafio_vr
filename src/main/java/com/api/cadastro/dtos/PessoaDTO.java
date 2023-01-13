package com.api.cadastro.dtos;

import java.util.Date;
import java.util.List;

import com.api.cadastro.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

	@JsonIgnore
	private int idPessoa;
	private Date dataNascimento;
	private String nome;
	private String endereco;
	private String documento;
	private TipoPessoa tipoPessoa;
	private List<TelefoneDTO> telefone;
}
