package br.com.zupacademy.andressa.casadocodigo.advice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.andressa.casadocodigo.controller.dto.request.AutorDtoRequest;
import br.com.zupacademy.andressa.casadocodigo.model.Autor;
import br.com.zupacademy.andressa.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDtoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorDtoRequest request = (AutorDtoRequest) target;

		Optional<Autor> optional = autorRepository.findByEmail(request.getEmail());
		if (optional.isPresent()) {
			errors.rejectValue("email", null, "já existe um autor(a) com o e-mail " + request.getEmail());
		}

	}

}
