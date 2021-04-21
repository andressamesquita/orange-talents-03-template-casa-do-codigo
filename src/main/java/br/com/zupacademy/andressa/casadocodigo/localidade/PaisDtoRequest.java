package br.com.zupacademy.andressa.casadocodigo.localidade;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.andressa.casadocodigo.validators.UniqueValue;

public class PaisDtoRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;


	@Deprecated
	public PaisDtoRequest() {

	}

	public PaisDtoRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}

}
