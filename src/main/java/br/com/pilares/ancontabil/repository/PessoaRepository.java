package br.com.pilares.ancontabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.ancontabil.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
