package com.api.cadastro.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.dtos.PessoaDTO;
import com.api.cadastro.entities.Pessoa;
import com.api.cadastro.repositories.PessoaRepository;
import com.api.cadastro.services.PessoaService;


@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaRepository repository;
	
	private String msgErro;
	
	//private ModelMapper mapper;
	
	private static final Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);
	
	@Override
	public List<PessoaDTO> findAll() throws Exception {
		log.info("Buscando todas os registros de pessoas.");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<PessoaDTO> pessoasRetorno = new ArrayList<PessoaDTO>();
		
		try {
			//pessoas = this.repository.findAll().stream().map(pessoa-> mapper.mapModels(pessoa, PessoaDTO.class));
			for(Pessoa pessoa: pessoas) {
			//	pessoasRetorno.add(mapper.ma);
			}
			log.info("Busca realizada com sucesso");
			return pessoasRetorno;
		}catch (Exception e) {
			msgErro = "Erro ao buscar pessoas. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public PessoaDTO findById(Integer id_pessoa) throws Exception {
		log.info("Buscando pessoa.");
		Pessoa pessoa = new Pessoa();
		try {
			pessoa = this.repository.findByIdPessoa(id_pessoa);
			if(pessoa == null) {
				throw new Exception("Sem resultados.");
			}
			log.info("Pessoa encontrado.");
			return null;// new PessoaDTO(pessoa);
		}catch (Exception e) {
			msgErro = "Erro ao buscar pessoa. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public PessoaDTO save(PessoaDTO pessoaDTO) throws Exception {
		if(pessoaDTO.equals(null)){
			throw new Exception("Pesquisa em branco. ");
		}
		log.info("Salvando pessoa");
		Pessoa pessoa = new Pessoa();
		try {
			//pessoa = this.repository.save(pessoaDTO.toEntity());
			//return new PessoaDTO(pessoa);
			return null;
		}catch (Exception e) {
			msgErro = "Erro ao salvar pessoa. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

	@Override
	public void delete(Integer id_pessoa) throws Exception {
		Pessoa pessoa = new Pessoa();
		log.info("Deletando pessoa...");
		
		try{
			pessoa = this.repository.findByIdPessoa(id_pessoa);
			this.repository.delete(pessoa);
		}catch (Exception e) {;
			msgErro = "Erro pessoa não pode ser deletado. "+e.getMessage();
			log.info(msgErro);
			throw new Exception(msgErro);
		}
	}

}
