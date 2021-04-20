package br.com.zupacademy.andressa.casadocodigo.livro;

import java.math.BigDecimal;

public class LivroDtoResponse {

	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private Integer qtdPaginas;
	private String categoria;
	private String autor;
	

	public LivroDtoResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.qtdPaginas = livro.getQtdPaginas();
		this.categoria = livro.getCategoria().getNome();
		this.autor = livro.getAutor().getNome();
	}
	

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getAutor() {
		return autor;
	}
	

}
