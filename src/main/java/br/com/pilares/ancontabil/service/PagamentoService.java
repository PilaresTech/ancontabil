package br.com.pilares.ancontabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.PagamentoConverter;
import br.com.pilares.ancontabil.feignclients.MessageClient;
import br.com.pilares.ancontabil.model.dto.PagamentoDTO;
import br.com.pilares.ancontabil.model.dto.PagamentoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pagamento;
import br.com.pilares.ancontabil.model.form.MessageForm;
import br.com.pilares.ancontabil.model.form.PagamentoForm;
import br.com.pilares.ancontabil.repository.PagamentoRepository;

@Service
public class PagamentoService extends BaseService<PagamentoRepository, 
	PagamentoConverter,
	Pagamento,
	PagamentoForm,
	PagamentoForm,
	PagamentoDTO,
	PagamentoDetailsDTO
	>{
	
	public PagamentoService(PagamentoConverter converter, PagamentoRepository repository) {
		super(converter, repository);
	}
	
	@Autowired
	private MessageClient messageClient;
	
	@Override
	public void afterCreate(PagamentoForm form, Pagamento entity) {
		System.out.println(entity.getContato());
		messageClient.notificarSolicitacao(new MessageForm(entity.getSolicitacao().getProduto().getNome(), entity.getContato()));
		super.afterCreate(form, entity);
	}

}
