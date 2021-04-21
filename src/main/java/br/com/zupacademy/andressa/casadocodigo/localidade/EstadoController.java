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
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDtoResponse> cadastrar(@RequestBody @Valid EstadoDtoRequest request) {
		if (paisRepository.existsById(request.getIdPais())) {
			Estado estado = request.toModel(paisRepository);
			estadoRepository.save(estado);

			return ResponseEntity.ok(new EstadoDtoResponse(estado));
		}

		return ResponseEntity.badRequest().build();

	}

}
