package br.com.zupacademy.andressa.casadocodigo.controller.dto.response;

import br.com.zupacademy.andressa.casadocodigo.model.Categoria;

public class CategoriaDtoResponse {

	private String nome;

	public CategoriaDtoResponse(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

}
