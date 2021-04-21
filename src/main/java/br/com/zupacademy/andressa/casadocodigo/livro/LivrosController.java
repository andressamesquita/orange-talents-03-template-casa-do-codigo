package br.com.zupacademy.andressa.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping
	public ResponseEntity<List<LivroDtoLista>> listarLivros() {
		List<Livro> livros = livroRepository.findAll();
		return ResponseEntity.ok(new LivroDtoLista().converter(livros));

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroDto(livro.get()));
		}

		return ResponseEntity.notFound().build();
	}

}
