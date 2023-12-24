package br.com.pilares.ancontabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.feignclients.MessageClient;
import br.com.pilares.ancontabil.model.dto.MessageDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDTO;
import br.com.pilares.ancontabil.model.dto.SolicitacaoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.form.MessageForm;
import br.com.pilares.ancontabil.model.form.SolicitacaoForm;
import br.com.pilares.ancontabil.service.ProdutoService;
import br.com.pilares.ancontabil.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController extends BaseController<
	SolicitacaoService, Solicitacao, SolicitacaoForm, SolicitacaoForm, SolicitacaoDTO, SolicitacaoDetailsDTO>{

	public SolicitacaoController(SolicitacaoService service) {
		super(service);
	}
}
