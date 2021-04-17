package br.com.zupacademy.andressa.casadocodigo.controller.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.andressa.casadocodigo.model.Autor;

public class AutorDtoRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDtoRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(nome, email, descricao);

	}
}