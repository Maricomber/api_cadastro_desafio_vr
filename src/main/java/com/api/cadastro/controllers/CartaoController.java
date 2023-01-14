package com.api.cadastro.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.cadastro.dtos.CartaoDTO;
import com.api.cadastro.response.Response;
import com.api.cadastro.services.CartaoService;

import io.swagger.annotations.*;

@RestController
@RequestMapping(path = {"/api/cartao"})
public class CartaoController {
	
	@Autowired
	CartaoService service;
	
	@ApiOperation(value = "Retorna uma lista de cartões")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Lista de cartões retornada com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<List<CartaoDTO>>> findAll(HttpServletRequest request) {
		
		Response<List<CartaoDTO>> response = new Response<List<CartaoDTO>>();
		List<String>erros = new ArrayList<String>();
		
		try{
			List<CartaoDTO>cartaoDTO = this.service.findAll();
			
			if(cartaoDTO.isEmpty()) {
				throw new Exception("Registro de cartões não encontrado");
			}
			response.setData(cartaoDTO);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@ApiOperation(value = "Retorna uma cartão por id")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cartão pesquisada com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(path = {"/{id}"},produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<CartaoDTO>> findById(@PathVariable Integer id){
		
		List<String>erros = new ArrayList<String>();
		Response<CartaoDTO>response = new Response<CartaoDTO>();
		CartaoDTO cartaoDTO;
		
		try {
			
			if(id == null) {
				throw new Exception("Campos em branco");
			}
			
			cartaoDTO= this.service.findById(id);
			
			if(cartaoDTO.equals(null)) {
				throw new Exception("Usuario não encontrado. ");
			}
			response.setData(cartaoDTO);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@ApiOperation(value = "Cria um registro de cartão")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Registro de cartão criado com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
	public @ResponseBody ResponseEntity<Response<CartaoDTO>> save(@RequestBody CartaoDTO cartaoDTO) {
		
		Response<CartaoDTO> response = new Response<CartaoDTO>();
		List<String>erros = new ArrayList<String>();
		
		try {

			if(cartaoDTO == null) {
				throw new Exception("Campos vazios. ");
			}
			cartaoDTO = this.service.save(cartaoDTO);
			response.setData(cartaoDTO);
			return ResponseEntity.ok(response);
			
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@ApiOperation(value = "Atualiza um registro de cartão")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cartão atualizado com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<CartaoDTO>> update(@RequestBody CartaoDTO cartaoDTO){
		
		List<String>erros = new ArrayList<String>();
		Response<CartaoDTO>response = new Response<CartaoDTO>();
		
		try {
			cartaoDTO = this.service.save(cartaoDTO);
			if(cartaoDTO.equals(null)) {
				return ResponseEntity.badRequest().body(response);
			}
		response.setData(cartaoDTO);
		return ResponseEntity.ok(response);
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
	}

	@ApiOperation(value = "Deleta um registro de cartão")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cartão deletado com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Response<String>> delete(@PathVariable Integer id) {
		
		Response<String> response = new Response<String>();
		List<String>erros = new ArrayList<String>();
		
		try {
			if(id == null) {
				throw new Exception("Campos em branco. ");
			}
			this.service.delete(id);
			response.setData("Deletado com sucesso!");
		}catch (Exception e) {
			erros.add(e.getMessage());
			response.setErrors(erros);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
}
