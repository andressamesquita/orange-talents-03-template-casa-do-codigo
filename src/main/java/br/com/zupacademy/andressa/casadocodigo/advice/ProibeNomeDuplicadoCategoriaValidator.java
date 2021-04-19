package br.com.zupacademy.andressa.casadocodigo.advice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.andressa.casadocodigo.controller.dto.request.CategoriaDtoRequest;
import br.com.zupacademy.andressa.casadocodigo.model.Categoria;
import br.com.zupacademy.andressa.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDtoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaDtoRequest request = (CategoriaDtoRequest) target;

		Optional<Categoria> optional = categoriaRepository.findByNome(request.getNome());
		if (optional.isPresent()) {
			errors.rejectValue("nome", null, "já existe uma categoria de nome " + request.getNome());
		}
	}
}
