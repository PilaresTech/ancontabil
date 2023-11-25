package br.com.pilares.ancontabil.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.dto.ContratoDTO;
import br.com.pilares.ancontabil.model.dto.ContratoDetailsDTO;
import br.com.pilares.ancontabil.model.dto.ProdutoDTO;
import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.form.ContratoForm;
import br.com.pilares.ancontabil.service.ContratoService;

@RequestMapping("/contrato")
@RestController
public class ContratoController extends BaseController<ContratoService, Contrato, ContratoForm, ContratoForm, ContratoDTO, ContratoDetailsDTO>{

	private ContratoService service;
	
	public ContratoController(ContratoService service) {
		super(service);
		this.service = service;
	}
	
	@PostMapping("/{id}/produto")
	public Map addProdutos(@PathVariable Long id, @RequestBody List<ProdutoDTO> produtos) throws NotFoundException {
		return service.addProdutos(id, produtos);
	}
	
	@DeleteMapping("/{id}/produto")
	public void addProdutos(@PathVariable Long id, @RequestBody ProdutoDTO produto) throws NotFoundException {
		service.deleteProdutos(id, produto);
	}
	
}
