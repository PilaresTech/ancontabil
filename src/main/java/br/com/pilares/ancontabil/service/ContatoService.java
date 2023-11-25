package br.com.pilares.ancontabil.service;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.ContatoConverter;
import br.com.pilares.ancontabil.model.dto.ContatoDTO;
import br.com.pilares.ancontabil.model.dto.ContatoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Contato;
import br.com.pilares.ancontabil.model.form.ContatoForm;
import br.com.pilares.ancontabil.repository.ContatoRepository;

@Service
public class ContatoService extends BaseService<ContatoRepository, ContatoConverter, Contato, ContatoForm, ContatoForm, ContatoDTO, ContatoDetailsDTO>{

	public ContatoService(ContatoConverter converter, ContatoRepository repository) {
		super(converter, repository);
	}	
	
}
