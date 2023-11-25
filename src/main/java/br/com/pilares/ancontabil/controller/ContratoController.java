package br.com.pilares.ancontabil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.dto.ContratoDTO;
import br.com.pilares.ancontabil.model.dto.ContratoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.form.ContratoForm;
import br.com.pilares.ancontabil.service.ContratoService;

@RequestMapping("/contrato")
@RestController
public class ContratoController extends BaseController<ContratoService, Contrato, ContratoForm, ContratoForm, ContratoDTO, ContratoDetailsDTO>{

	public ContratoController(ContratoService service) {
		super(service);
	}
	
}
