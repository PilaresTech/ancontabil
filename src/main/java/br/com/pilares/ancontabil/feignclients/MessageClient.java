package br.com.pilares.ancontabil.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.pilares.ancontabil.model.dto.MessageDTO;
import br.com.pilares.ancontabil.model.form.MessageForm;

@FeignClient(name = "message", url = "http://localhost:3000")
public interface MessageClient {
		
	@PostMapping(value = "/message")
	ResponseEntity<MessageDTO> notificarSolicitacao(@RequestBody MessageForm form);

}
