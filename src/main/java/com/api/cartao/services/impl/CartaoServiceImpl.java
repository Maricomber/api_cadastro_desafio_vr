package com.api.cartao.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cartao.dtos.CartaoDTO;
import com.api.cartao.entities.Cartao;
import com.api.cartao.repositories.CartaoRepository;
import com.api.cartao.services.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService{

	@Autowired
	CartaoRepository repository;
	
	private String msgErro;
	
	//private ModelMapper mapper;
	
	private static final Logger log = LoggerFactory.getLogger(CartaoServiceImpl.class);
	
	@Override
	public List<CartaoDTO> findAll() throws Exception {
		log.info("Buscando todas os registros de cartaos.");
		List<Cartao> cartaos = new ArrayList<Cartao>();
		List<CartaoDTO> cartaosRetorno = new ArrayList<CartaoDTO>();
		
		try {
			//cartaos = this.repository.findAll().stream().map(cartao-> mapper.mapModels(cartao, CartaoDTO.class));
			for(Cartao cartao: cartaos) {
			//	cartaosRetorno.add(mapper.ma);
			}
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
			return null;// new CartaoDTO(cartao);
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
			//cartao = this.repository.save(cartaoDTO.toEntity());
			//return new CartaoDTO(cartao);
			return null;
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
