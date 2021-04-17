package br.com.zupacademy.andressa.casadocodigo.controller.dto.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.andressa.casadocodigo.model.Autor;

public class AutorDtoResponse {

	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCadastro;

	public AutorDtoResponse(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instanteCadastro = autor.getInstanteCadastro();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getInstanteCadastro() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		return instanteCadastro.format(formatter);
	}

}
