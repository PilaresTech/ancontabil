package br.com.pilares.ancontabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.ancontabil.model.entities.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

}
