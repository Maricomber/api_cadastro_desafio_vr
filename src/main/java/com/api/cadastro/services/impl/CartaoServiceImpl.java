package com.api.cadastro.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.cadastro.dtos.CartaoDTO;
import com.api.cadastro.response.Response;
import com.api.cadastro.services.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService{
	
	private String msgErro;
	
	private ModelMapper mapper = new ModelMapper();
	
	private static final Logger log = LoggerFactory.getLogger(CartaoServiceImpl.class);
	
	private static final String api_cadastro_cartao = "http://localhost:8084/api/cartao/";
	
	RestTemplate restTemplate = new RestTemplate(); 
	
	@Override
	public List<CartaoDTO> findAll() throws SQLException {
		log.info("Buscando todas os registros de cartaos.");
		List<CartaoDTO> cartaosRetorno = new ArrayList<>();
		
		try {
			Response<CartaoDTO> response = restTemplate.getForObject(api_cadastro_cartao, Response.class);
			log.info("Busca realizada com sucesso");
			return mapper.map(response.getData(), List.class);
		}catch (Exception e) {
			msgErro = "Erro ao buscar cartaos. "+e.getMessage();
			log.info(msgErro);
			throw new SQLException(msgErro);
		}
	}

	@Override
	public CartaoDTO findById(Integer idCartao) throws SQLException {
		log.info("Buscando cartao.");
		try {
			Response<CartaoDTO> response = restTemplate.getForObject(api_cadastro_cartao, Response.class);
			log.info("Busca realizada com sucesso");
			return mapper.map(response.getData(), CartaoDTO.class);
		}catch (Exception e) {
			msgErro = "Erro ao buscar cartao. "+e.getMessage();
			log.info(msgErro);
			throw new SQLException(msgErro);
		}
	}

	@Override
	public CartaoDTO save(CartaoDTO cartaoDTO) throws SQLException {
		if(cartaoDTO == null){
			throw new NoResultException("Pesquisa em branco. ");
		}
		log.info("Salvando cartao");
		try {
			Response<CartaoDTO>response = restTemplate.postForObject(api_cadastro_cartao, cartaoDTO, Response.class);
			log.info("Busca realizada com sucesso");
			return mapper.map(response.getData(), CartaoDTO.class);
		}catch (Exception e) {
			msgErro = "Erro ao salvar cartao. "+e.getMessage();
			log.info(msgErro);
			throw new SQLException(msgErro);
		}
	}

	@Override
	public void delete(Integer idCartao) throws SQLException {
		log.info("Deletando cartao...");
		
		try{
			restTemplate.delete(api_cadastro_cartao+idCartao, Integer.class);
		}catch (Exception e) {
			msgErro = "Erro cartao não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new SQLException(msgErro);
		}
	}

}
