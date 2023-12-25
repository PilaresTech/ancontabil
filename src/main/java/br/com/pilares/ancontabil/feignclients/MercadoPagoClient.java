package br.com.pilares.ancontabil.feignclients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.resources.payment.Payment;

import br.com.pilares.ancontabil.model.dto.MPPaymentDTO;
import feign.Headers;

@FeignClient(name = "mercadoPago", url = "https://api.mercadopago.com/v1")
public interface MercadoPagoClient {
	
	@PostMapping(value = "/payments")
	ResponseEntity<Map<String, Object>> criarPagamento(
			@RequestBody MPPaymentDTO body, 
			@RequestHeader(value = "Authorization", required = true) String token,
			@RequestHeader(value = "X-Idempotency-Key") String key
			);

}
