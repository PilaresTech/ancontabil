package br.com.pilares.ancontabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.pilares.ancontabil.converter.PessoaConverter;
import br.com.pilares.ancontabil.converter.SolicitacaoConverter;
import br.com.pilares.ancontabil.feignclients.MessageClient;
import br.com.pilares.ancontabil.model.dto.MessageDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pagamento;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.form.MessageForm;
import br.com.pilares.ancontabil.model.form.PagamentoForm;
import br.com.pilares.ancontabil.model.form.SolicitacaoForm;
import br.com.pilares.ancontabil.repository.PessoaRepository;
import br.com.pilares.ancontabil.repository.SolicitacaoRepository;
import feign.FeignException;

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
