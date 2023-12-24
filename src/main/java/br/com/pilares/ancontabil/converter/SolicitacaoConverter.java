package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.SolicitacaoDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.form.SolicitacaoForm;

@Service
public class SolicitacaoConverter implements IConverterBase<Solicitacao,
	SolicitacaoForm,
	SolicitacaoForm,
	SolicitacaoDTO,
	SolicitacaoDetailsDTO>{

	@Override
	public SolicitacaoDetailsDTO entityParaDetailsDTO(Solicitacao entity) {
		return new SolicitacaoDetailsDTO(entity);
	}
	
	@Override
	public SolicitacaoDTO entityParaDTO(Solicitacao entity) {
		return new SolicitacaoDTO(entity);
	}
	
	@Override
	public Solicitacao formParaEntity(SolicitacaoForm form) {
		return new Solicitacao(form);
	}
	
	@Override
	public List<SolicitacaoDTO> ListEntityParaListDTO(List<Solicitacao> entitys) {
		return new SolicitacaoDTO().converter(entitys, SolicitacaoDTO.class);
	}
	
	@Override
	public Solicitacao setarValoresEditar(Solicitacao entity, SolicitacaoForm formEditar) {
		return new Solicitacao().setarValoresEditar(entity, formEditar);
	}
	
}
