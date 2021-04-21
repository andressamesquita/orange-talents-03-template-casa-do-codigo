package br.com.zupacademy.andressa.casadocodigo.localidade;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zupacademy.andressa.casadocodigo.validators.UniqueValue;

public class EstadoDtoRequest {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	private Long idPais;

	@Deprecated
	public EstadoDtoRequest() {

	}

	public EstadoDtoRequest(@NotBlank String nome, @NotBlank Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(idPais).get();
		return new Estado(nome, pais);
	}

}
