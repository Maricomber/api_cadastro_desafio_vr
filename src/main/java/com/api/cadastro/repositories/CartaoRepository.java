package com.api.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cadastro.entities.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
	Cartao findByIdCartao(Integer id_cartao);

}
