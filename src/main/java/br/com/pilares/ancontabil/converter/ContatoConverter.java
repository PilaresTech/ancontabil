package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.ContatoDTO;
import br.com.pilares.ancontabil.model.entities.Contato;
import br.com.pilares.ancontabil.model.form.ContatoForm;

@Service
public class ContatoConverter implements ConverterBase<Contato, ContatoForm, ContatoForm, ContatoDTO, ContatoDTO>{

	@Override
	public ContatoDTO entityParaDetailsDTO(Contato entity) {
		return new ContatoDTO(entity);
	}
	
	@Override
	public ContatoDTO entityParaDTO(Contato entity) {
		return new ContatoDTO(entity);
	}
	
	@Override
	public Contato formParaEntity(ContatoForm form) {
		return new Contato(form);
	}
	
	@Override
	public List<ContatoDTO> ListEntityParaListDTO(List<Contato> entitys) {
		return ContatoDTO.converter(entitys);
	}
	
	@Override
	public Contato setarValoresEditar(Contato entity, ContatoForm formEditar) {
		return Contato.setarValoresEditar(entity, formEditar);
	}
	
}
