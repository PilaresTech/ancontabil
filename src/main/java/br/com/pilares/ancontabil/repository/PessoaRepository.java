package br.com.pilares.ancontabil.repository;

import java.util.Optional;

import br.com.pilares.ancontabil.model.entities.Pessoa;

public interface PessoaRepository extends BaseRepository<Pessoa> {

	Optional<Pessoa> findByDocumento(String documento);
	
}
