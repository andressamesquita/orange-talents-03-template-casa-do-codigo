package br.com.zupacademy.andressa.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer qtdPaginas;
	private String isbn;
	private String dataPublicacao;

	private String categoria;
	private String autor;
	private String descricaoAutor;

	@Deprecated
	public DetalhesLivroDto() {

	}

	public DetalhesLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.qtdPaginas = livro.getQtdPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getdataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.categoria = livro.getCategoria().getNome();
		this.autor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getAutor() {
		return autor;
	}
	
	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
	public String getDataPublicacao() {
		return dataPublicacao;
	}

}
