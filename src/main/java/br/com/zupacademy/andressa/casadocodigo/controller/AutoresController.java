package br.com.zupacademy.andressa.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.andressa.casadocodigo.controller.dto.request.AutorDtoRequest;
import br.com.zupacademy.andressa.casadocodigo.controller.dto.response.AutorDtoResponse;
import br.com.zupacademy.andressa.casadocodigo.model.Autor;
import br.com.zupacademy.andressa.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDtoResponse> cadastrar(@RequestBody @Valid AutorDtoRequest autorDtoRequest) {
		Autor autor = autorDtoRequest.toModel();
		autorRepository.save(autor);
					
		return ResponseEntity.ok(new AutorDtoResponse(autor));
		
		
	}

}
