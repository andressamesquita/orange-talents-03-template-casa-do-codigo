package br.com.zupacademy.andressa.casadocodigo.localidade;

public class PaisDtoResponse {

	private String nome;

	@Deprecated
	public PaisDtoResponse() {

	}

	public PaisDtoResponse(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}


}
