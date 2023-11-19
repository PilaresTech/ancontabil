package br.com.pilares.ancontabil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.dto.PessoaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.form.PessoaForm;
import br.com.pilares.ancontabil.model.form.PessoaFormEdit;
import br.com.pilares.ancontabil.service.PessoaService;

@RequestMapping("/pessoa")
@RestController
public class PessoaController extends BaseController<PessoaService, Pessoa, PessoaForm, PessoaFormEdit, PessoaDTO, PessoaDetailsDTO>{

	public PessoaController(PessoaService service) {
		super(service);
	}			
	
}