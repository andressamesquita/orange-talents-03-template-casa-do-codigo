package br.com.zupacademy.andressa.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.andressa.casadocodigo.localidade.Estado;
import br.com.zupacademy.andressa.casadocodigo.localidade.EstadoRepository;
import br.com.zupacademy.andressa.casadocodigo.localidade.Pais;
import br.com.zupacademy.andressa.casadocodigo.localidade.PaisRepository;

public class ClienteDtoRequest {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String documento; /* cpf ou cnpj >>> documento eh unico no sistema */

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	/*
	 * se o país tiver estados, um estado precisa ser selecionado
	 */
	@NotNull
	private Long idPais;

	private Long idEstado; /* soh aparece se o pais tiver estados cadastrados */

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteDtoRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {

		Pais pais = getPais(paisRepository);

		Estado estado = getEstado(estadoRepository, pais);

		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone,
				cep);

	}

	private Estado getEstado(EstadoRepository estadoRepository, Pais pais) {

		Estado estado = null;

		if (pais.getEstados().size() == 0 && idEstado != null) {
			throw new IllegalArgumentException(
					"Esse país não tem estados e você está selecionando um estado para ele!");
		}

		if (idEstado == null) {
			if (pais.getEstados().size() > 0) {
				throw new IllegalArgumentException("Você deveria ter selecionado um estado para esse país");
			}

			return null;
		}

		Optional<Estado> optionalEstado = estadoRepository.findById(this.idEstado);

		if (optionalEstado.isPresent()) {
			estado = optionalEstado.get();

		} else {
			if (pais.getEstados().size() > 0) {
				throw new IllegalArgumentException(
						"O estado escolhido não existe, mas esse país possui estados, escolha um estado válido");
			}

		}

		if (!pais.euPossuoEsseEstado(estado)) {
			throw new IllegalArgumentException("Este estado não pertence a este país");

		}

		return estado;
	}

	private Pais getPais(PaisRepository paisRepository) {

		Pais pais = null;

		Optional<Pais> optionalPais = paisRepository.findById(this.idPais);

		if (optionalPais.isPresent()) {
			pais = optionalPais.get();

		} else {
			throw new IllegalArgumentException("Este pais não está cadastrado");
		}

		return pais;
	}

}
