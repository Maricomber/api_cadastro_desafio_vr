package com.api.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.cadastro.dtos.PessoaDTO;

@Service
public interface PessoaService {

	List<PessoaDTO>findAll() throws Exception;
	
	PessoaDTO findById(Integer id_pessoa) throws Exception;
	
	PessoaDTO save(PessoaDTO pessoaDTO) throws Exception;
	
	void delete(Integer id_pessoa) throws Exception;
	
}
