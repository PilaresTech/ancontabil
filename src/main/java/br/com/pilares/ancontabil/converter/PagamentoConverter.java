package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.PagamentoDTO;
import br.com.pilares.ancontabil.model.dto.PagamentoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pagamento;
import br.com.pilares.ancontabil.model.form.PagamentoForm;

@Service
public class PagamentoConverter implements IConverterBase<Pagamento,
	PagamentoForm, 
	PagamentoForm, 
	PagamentoDTO, 
	PagamentoDetailsDTO> {

	@Override
	public PagamentoDetailsDTO entityParaDetailsDTO(Pagamento entity) {
		return new PagamentoDetailsDTO(entity);
	}
	
	@Override
	public PagamentoDTO entityParaDTO(Pagamento entity) {
		return new PagamentoDTO(entity);
	}
	
	@Override
	public Pagamento formParaEntity(PagamentoForm form) {
		return new Pagamento(form);
	}
	
	@Override
	public List<PagamentoDTO> ListEntityParaListDTO(List<Pagamento> entitys) {
		return new PagamentoDTO().converter(entitys, PagamentoDTO.class);
	}
	
	@Override
	public Pagamento setarValoresEditar(Pagamento entity, PagamentoForm formEditar) {
		return new Pagamento().setarValoresEditar(entity, formEditar);
	}
	
}
