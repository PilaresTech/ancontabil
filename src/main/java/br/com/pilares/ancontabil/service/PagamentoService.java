package br.com.pilares.ancontabil.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.payment.PaymentPayer;
import com.mercadopago.resources.payment.PaymentPointOfInteraction;

import br.com.pilares.ancontabil.converter.PagamentoConverter;
import br.com.pilares.ancontabil.feignclients.MercadoPagoClient;
import br.com.pilares.ancontabil.feignclients.MessageClient;
import br.com.pilares.ancontabil.model.dto.MPPaymentDTO;
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
	
	@Value("${mercadopago.token}")
	private String token;
	
	@Value("${mercadopago.key}")
	private String key;
	
	@Autowired
	private MessageClient messageClient;

	@Autowired
	private MercadoPagoClient mercadoPagoClient;
	
	@Override
	public void beforeCreate(PagamentoForm form) {
		ResponseEntity<Map<String, Object>> result = mercadoPagoClient.criarPagamento(new MPPaymentDTO(form),"Bearer "+token, key);
		Map<String, Object> resultado = result.getBody();
		Map<String, Object> pointOfInteraction = (Map<String, Object>) resultado.get("point_of_interaction");
		Map<String, Object> transactionData = (Map<String, Object>) pointOfInteraction.get("transaction_data");
		form.setLink((String) transactionData.get("ticket_url"));
		super.beforeCreate(form);
	}
	
	@Override
	public void afterCreate(PagamentoForm form, Pagamento entity) {
		System.out.println(entity.getContato());
		messageClient.notificarSolicitacao(new MessageForm(entity.getSolicitacao().getProduto().getNome() + ": " + form.getLink(), entity.getContato()));
		super.afterCreate(form, entity);
	}

}
