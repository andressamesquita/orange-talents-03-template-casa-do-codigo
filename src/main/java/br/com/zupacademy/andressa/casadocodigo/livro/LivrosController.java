package br.com.zupacademy.andressa.casadocodigo.livro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.andressa.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.andressa.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<LivroDtoResponse> cadastrarLivro(@RequestBody @Valid LivroDtoRequest request) {
		if (categoriaRepository.existsById(request.getIdCategoria())
				|| autorRepository.existsById(request.getIdAutor())) {
			Livro livro = request.toModel(autorRepository, categoriaRepository);
			livroRepository.save(livro);

			return ResponseEntity.ok(new LivroDtoResponse(livro));
		}

		return ResponseEntity.badRequest().build();

	}

}
