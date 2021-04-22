package br.com.zupacademy.andressa.casadocodigo.cliente;

public class ClienteDtoResponse {

	private Long id;

	public ClienteDtoResponse(Cliente cli) {
		this.id = cli.getId();

	}

	public Long getId() {
		return id;
	}

}
