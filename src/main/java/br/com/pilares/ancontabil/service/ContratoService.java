package br.com.pilares.ancontabil.service;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.ContratoConverter;
import br.com.pilares.ancontabil.model.dto.ContratoDTO;
import br.com.pilares.ancontabil.model.dto.ContratoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.form.ContratoForm;
import br.com.pilares.ancontabil.repository.ContratoRepository;

@Service
public class ContratoService extends BaseService<ContratoRepository, ContratoConverter, Contrato, ContratoForm, ContratoForm, ContratoDTO, ContratoDetailsDTO> {

	public ContratoService(ContratoRepository repository, ContratoConverter converter) {
		super(converter, repository);
	}
	
}
