package br.com.zupacademy.andressa.casadocodigo.localidade;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<PaisDtoResponse> cadastrar(@RequestBody @Valid PaisDtoRequest request) {
		Pais pais = request.toModel();
		paisRepository.save(pais);
		
		return ResponseEntity.ok(new PaisDtoResponse(pais));
	}
}
