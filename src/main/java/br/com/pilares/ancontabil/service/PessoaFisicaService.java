package br.com.pilares.ancontabil.service;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.PessoaFisicaConverter;
import br.com.pilares.ancontabil.model.dto.PessoaFisicaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaFisicaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.PessoaFisica;
import br.com.pilares.ancontabil.model.form.PessoaFisicaForm;
import br.com.pilares.ancontabil.model.form.PessoaFisicaFormEdit;
import br.com.pilares.ancontabil.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService extends 
	BaseService<PessoaFisicaRepository, PessoaFisicaConverter, PessoaFisica, PessoaFisicaForm, PessoaFisicaFormEdit, PessoaFisicaDTO, PessoaFisicaDetailsDTO>
	{

	public PessoaFisicaService(PessoaFisicaConverter converter, PessoaFisicaRepository repository) {
		super(converter, repository);
	}
	
	
	
}