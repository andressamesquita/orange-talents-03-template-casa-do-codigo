package br.com.zupacademy.andressa.casadocodigo.advice;

public class ErroAutorRequest {

	private String campo;
	private String erro;
	
	public ErroAutorRequest(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
	
}
