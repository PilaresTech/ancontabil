package br.com.pilares.ancontabil.feignclients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;

@FeignClient(name = "mercadoPago", url = "https://api.mercadopago.com/v1")
public interface MercadoPagoClient {
	
	@PostMapping(value = "/payments")
	@Headers("Authorization: Bearer {token}")
	ResponseEntity<Object> criarPagamento(@RequestBody Map<String, String> body, @RequestHeader("token") String token);

}
