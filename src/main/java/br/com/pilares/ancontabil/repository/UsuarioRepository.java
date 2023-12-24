package br.com.pilares.ancontabil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.ancontabil.model.entities.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario>{

	Optional<Usuario> findByPessoaDocumento(String documento);
	
}