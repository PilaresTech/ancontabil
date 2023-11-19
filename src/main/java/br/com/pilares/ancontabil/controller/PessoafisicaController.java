package br.com.pilares.ancontabil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.dto.PessoaFisicaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaFisicaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.PessoaFisica;
import br.com.pilares.ancontabil.model.form.PessoaFisicaForm;
import br.com.pilares.ancontabil.model.form.PessoaFisicaFormEdit;
import br.com.pilares.ancontabil.service.PessoaFisicaService;

@RequestMapping("/pessoafisica")
@RestController
public class PessoafisicaController extends BaseController<PessoaFisicaService, PessoaFisica, PessoaFisicaForm, PessoaFisicaFormEdit, PessoaFisicaDTO, PessoaFisicaDetailsDTO>{

	public PessoafisicaController(PessoaFisicaService service) {
		super(service);
	}

			
	
}