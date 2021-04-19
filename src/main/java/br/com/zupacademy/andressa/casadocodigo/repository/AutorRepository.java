package br.com.zupacademy.andressa.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.andressa.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	public Optional<Autor> findByEmail(String email);
}
