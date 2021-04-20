package br.com.zupacademy.andressa.casadocodigo.autor;

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

import br.com.zupacademy.andressa.casadocodigo.advice.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDtoResponse> cadastrar(@RequestBody @Valid AutorDtoRequest autorDtoRequest) {

		Autor autor = autorDtoRequest.toModel();
		autorRepository.save(autor);

		return ResponseEntity.ok(new AutorDtoResponse(autor));

	}

}
