package com.api.cartao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cartao.entities.Cartao;


public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
	Cartao findByIdCartao(Integer id_cartao);

}
