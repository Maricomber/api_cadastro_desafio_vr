package com.api.cadastro.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Response<T>{

	private T data;
	private List < String > errors;
	
}