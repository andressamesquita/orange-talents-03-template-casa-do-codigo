package br.com.zupacademy.andressa.casadocodigo.categoria;

public class CategoriaDtoResponse {

	private String nome;

	public CategoriaDtoResponse(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

}
