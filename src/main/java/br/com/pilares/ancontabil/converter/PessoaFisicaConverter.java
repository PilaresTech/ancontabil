package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.PessoaFisicaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaFisicaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.PessoaFisica;
import br.com.pilares.ancontabil.model.form.PessoaFisicaForm;
import br.com.pilares.ancontabil.model.form.PessoaFisicaFormEdit;

@Service
public class PessoaFisicaConverter implements ConverterBase<PessoaFisica, 
	PessoaFisicaForm, 
	PessoaFisicaFormEdit, 
	PessoaFisicaDTO, 
	PessoaFisicaDetailsDTO> {
	
	@Override
	public PessoaFisicaDetailsDTO entityParaDetailsDTO(PessoaFisica entity) {
		return new PessoaFisicaDetailsDTO(entity);
	}
	
	@Override
	public PessoaFisicaDTO entityParaDTO(PessoaFisica entity) {
		return new PessoaFisicaDTO(entity);
	}
	
	@Override
	public PessoaFisica formParaEntity(PessoaFisicaForm form) {
		return new PessoaFisica(form);
	}
	
	@Override
	public List<PessoaFisicaDTO> ListEntityParaListDTO(List<PessoaFisica> entitys) {
		return PessoaFisicaDTO.converter(entitys);
	}
	
	@Override
	public PessoaFisica setarValoresEditar(PessoaFisica entity, PessoaFisicaFormEdit formEditar) {
		return PessoaFisica.setarValoresEditar(entity, formEditar);
	}
	
}