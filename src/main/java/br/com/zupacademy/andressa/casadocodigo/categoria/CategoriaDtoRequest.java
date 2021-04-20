package br.com.zupacademy.andressa.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.andressa.casadocodigo.validators.UniqueValue;

public class CategoriaDtoRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	@JsonCreator
	public CategoriaDtoRequest(@JsonProperty("nome") @NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
