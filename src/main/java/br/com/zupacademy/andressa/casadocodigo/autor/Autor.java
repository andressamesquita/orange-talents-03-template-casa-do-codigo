package br.com.zupacademy.andressa.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCadastro = LocalDateTime.now();

	@Deprecated
	public Autor() {

	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor(Long id, String nome, String email, String descricao, LocalDateTime instanteCadastro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instanteCadastro = instanteCadastro;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

}
