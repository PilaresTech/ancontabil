package br.com.pilares.ancontabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.SolicitacaoConverter;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.form.PagamentoForm;
import br.com.pilares.ancontabil.model.form.SolicitacaoForm;
import br.com.pilares.ancontabil.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService extends BaseService<SolicitacaoRepository, SolicitacaoConverter, Solicitacao, SolicitacaoForm, SolicitacaoForm, SolicitacaoDTO, SolicitacaoDetailsDTO> {

	public SolicitacaoService(SolicitacaoConverter converter, SolicitacaoRepository repository) {
		super(converter, repository);
	}
	
	@Autowired
	private PagamentoService pagamentoService;

	@Override
	public void afterCreate(SolicitacaoForm form, Solicitacao entity) {
		entity.getPagamentos().add(pagamentoService.createBase(new PagamentoForm(entity)));
	}
	
}
