package br.com.zupacademy.andressa.casadocodigo.controller.dto.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaDtoRequest {

	@NotBlank
	private String nome;

	@JsonCreator
	public CategoriaDtoRequest(@JsonProperty("nome") @NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
