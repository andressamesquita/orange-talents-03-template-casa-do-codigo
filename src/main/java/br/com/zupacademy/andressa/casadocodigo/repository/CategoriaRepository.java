package br.com.zupacademy.andressa.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.andressa.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Optional<Categoria> findByNome(String nome);
}
