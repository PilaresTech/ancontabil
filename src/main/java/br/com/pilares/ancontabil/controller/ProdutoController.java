package br.com.pilares.ancontabil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.dto.ProdutoDTO;
import br.com.pilares.ancontabil.model.dto.ProdutoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.form.ProdutoEditForm;
import br.com.pilares.ancontabil.model.form.ProdutoForm;
import br.com.pilares.ancontabil.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController extends BaseController<ProdutoService, Produto, ProdutoForm, ProdutoEditForm, ProdutoDTO, ProdutoDetailsDTO> {

	public ProdutoController(ProdutoService service) {
		super(service);
	}
	
}
