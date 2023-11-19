package br.com.pilares.ancontabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.pilares.ancontabil.feignclients.MessageClient;
import br.com.pilares.ancontabil.model.dto.MessageDTO;
import br.com.pilares.ancontabil.model.form.MessageForm;
import feign.FeignException;

@Service
public class SolicitacaoService {

	@Autowired
	private MessageClient messageClient;

	public ResponseEntity<MessageDTO> notificarSolicitacao(@RequestBody MessageForm form){
		try {
			ResponseEntity<MessageDTO> result = messageClient.notificarSolicitacao(form);
			return result;
		} catch(FeignException e) {
			//mandar novamente para a fila
			return null;
		}
	}
	
}
