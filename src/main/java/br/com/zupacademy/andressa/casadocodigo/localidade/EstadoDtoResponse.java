package br.com.zupacademy.andressa.casadocodigo.localidade;

public class EstadoDtoResponse {

	private String nome;
	private Long idPais;

	@Deprecated
	public EstadoDtoResponse() {

	}

	public EstadoDtoResponse(Estado estado) {
		this.nome = estado.getNome();
		this.idPais = estado.getPais().getId();

	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

}
