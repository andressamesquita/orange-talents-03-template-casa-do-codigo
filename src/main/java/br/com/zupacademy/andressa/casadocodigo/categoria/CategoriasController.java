package br.com.zupacademy.andressa.casadocodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.andressa.casadocodigo.validators.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.andressa.casadocodigo.validators.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDtoResponse> cadastrarCategoria(@RequestBody @Valid CategoriaDtoRequest categoriaDtoRequest) {
		Categoria categoria = new Categoria(categoriaDtoRequest.getNome());
		categoriaRepository.save(categoria);

		return ResponseEntity.ok(new CategoriaDtoResponse(categoria));
	}

}
