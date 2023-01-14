package com.api.cadastro.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.dtos.CartaoDTO;
import com.api.cadastro.entities.Cartao;
import com.api.cadastro.repositories.CartaoRepository;
import com.api.cadastro.services.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService{

	@Autowired
	CartaoRepository repository;
	
	private String msgErro;
	
	private ModelMapper mapper = new ModelMapper();
	
	private static final Logger log = LoggerFactory.getLogger(CartaoServiceImpl.class);
	
	@Override
	public List<CartaoDTO> findAll() throws Exception {
		log.info("Buscando todas os registros de cartaos.");
		List<Cartao> cartaos = new ArrayList<Cartao>();
		List<CartaoDTO> cartaosRetorno = new ArrayList<CartaoDTO>();
		
		try {
			cartaos = this.repository.findAll();
			cartaos.stream().forEach(cartao->cartaosRetorno.add(mapper.map(cartao, CartaoDTO.class)));
			log.info("Busca realizada com sucesso");
			return cartaosRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar cartaos. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public CartaoDTO findById(Integer id_cartao) throws Exception {
		log.info("Buscando cartao.");
		Cartao cartao = new Cartao();
		try {
			cartao = this.repository.findByIdCartao(id_cartao);
			if(cartao == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Cartao encontrado.");
			return mapper.map(cartao, CartaoDTO.class);
		}catch (Exception e) {
			msgErro = "Erro ao buscar cartao. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public CartaoDTO save(CartaoDTO cartaoDTO) throws Exception {
		if(cartaoDTO.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando cartao");
		Cartao cartao = new Cartao();
		try {
			cartao = this.repository.save(mapper.map(cartaoDTO, Cartao.class));
			return mapper.map(cartao, CartaoDTO.class);
		}catch (Exception e) {
			msgErro = "Erro ao salvar cartao. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public void delete(Integer id_cartao) throws Exception {
		Cartao cartao = new Cartao();
		log.info("Deletando cartao...");
		
		try{
			cartao = this.repository.findByIdCartao(id_cartao);
			this.repository.delete(cartao);
		}catch (Exception e) {;
			msgErro = "Erro cartao não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
