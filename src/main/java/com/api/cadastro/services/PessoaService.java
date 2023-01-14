package com.api.cadastro.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.cadastro.dtos.PessoaDTO;

@Service
public interface PessoaService {

	List<PessoaDTO>findAll() throws SQLException;
	
	PessoaDTO findById(Integer idPessoa) throws SQLException;
	
	PessoaDTO save(PessoaDTO pessoaDTO) throws SQLException;
	
	void delete(Integer idPessoa) throws SQLException;
	
}
