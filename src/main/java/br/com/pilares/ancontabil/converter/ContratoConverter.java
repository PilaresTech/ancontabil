package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.ContratoDTO;
import br.com.pilares.ancontabil.model.dto.ContratoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.form.ContratoForm;

@Service
public class ContratoConverter implements IConverterBase<Contrato, ContratoForm, ContratoForm, ContratoDTO, ContratoDetailsDTO>{
	
	@Override
	public ContratoDetailsDTO entityParaDetailsDTO(Contrato entity) {
		return new ContratoDetailsDTO(entity);
	}
	
	@Override
	public ContratoDTO entityParaDTO(Contrato entity) {
		return new ContratoDTO(entity);
	}
	
	@Override
	public Contrato formParaEntity(ContratoForm form) {
		return new Contrato(form);
	}
	
	@Override
	public List<ContratoDTO> ListEntityParaListDTO(List<Contrato> entitys) {
		return new ContratoDTO().converter(entitys, ContratoDTO.class);
	}
	
	@Override
	public Contrato setarValoresEditar(Contrato entity, ContratoForm formEditar) {
		return new Contrato().setarValoresEditar(entity, formEditar);
	}
	

}
