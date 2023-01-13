package com.api.cartao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.cartao.dtos.CartaoDTO;

@Service
public interface CartaoService {

	List<CartaoDTO>findAll() throws Exception;
	
	CartaoDTO findById(Integer id_pessoa) throws Exception;
	
	CartaoDTO save(CartaoDTO cartaoDTO) throws Exception;
	
	void delete(Integer id_pessoa) throws Exception;
	
}

