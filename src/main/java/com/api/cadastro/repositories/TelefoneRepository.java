package com.api.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cadastro.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
	Telefone findByIdTelefone(Integer idTelefone);
}
