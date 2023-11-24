package br.com.pilares.ancontabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.ancontabil.model.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
