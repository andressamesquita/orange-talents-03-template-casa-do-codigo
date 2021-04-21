package br.com.zupacademy.andressa.casadocodigo.localidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(name = "estados")
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<>();

	@Deprecated
	public Pais() {

	}

	public Pais(String nome) {
		this.nome = nome;
	}
	
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

}
