package br.com.zupacademy.andressa.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDtoLista {

	private Long id;
	private String titulo;

	public LivroDtoLista() {

	}

	public LivroDtoLista(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<LivroDtoLista> converter(List<Livro> lista) {
		List<LivroDtoLista> listaDto = new ArrayList<LivroDtoLista>();
		for (Livro l : lista) {
			listaDto.add(new LivroDtoLista(l));
		}

		return listaDto;
	}
	

}
