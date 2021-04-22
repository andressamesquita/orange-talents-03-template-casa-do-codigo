package br.com.zupacademy.andressa.casadocodigo.cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.andressa.casadocodigo.localidade.EstadoRepository;
import br.com.zupacademy.andressa.casadocodigo.localidade.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDtoResponse> cadastrar(@RequestBody @Valid ClienteDtoRequest request) {
		Cliente cliente = request.toModel(paisRepository, estadoRepository);
		clienteRepository.save(cliente);

		return ResponseEntity.ok(new ClienteDtoResponse(cliente));
	}

}
