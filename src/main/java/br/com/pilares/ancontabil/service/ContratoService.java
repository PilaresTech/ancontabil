package br.com.pilares.ancontabil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.ContratoConverter;
import br.com.pilares.ancontabil.model.dto.ContratoDTO;
import br.com.pilares.ancontabil.model.dto.ContratoDetailsDTO;
import br.com.pilares.ancontabil.model.dto.ProdutoDTO;
import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.form.ContratoForm;
import br.com.pilares.ancontabil.repository.ContratoRepository;
import br.com.pilares.ancontabil.repository.ProdutoRepository;

@Service
public class ContratoService extends BaseService<ContratoRepository, ContratoConverter, Contrato, ContratoForm, ContratoForm, ContratoDTO, ContratoDetailsDTO> {

	private ContratoRepository repository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ContratoService(ContratoRepository repository, ContratoConverter converter) {
		super(converter, repository);
		this.repository = repository;
	}
	
	public Map<String, Object> addProdutos(Long id,  List<ProdutoDTO> produtos) throws NotFoundException {
		Optional<Contrato> contrato = repository.findById(id);
		List<Produto> produtosCadastrados = new ArrayList<>();
		List<ProdutoDTO> produtosNaoCadastrados = new ArrayList<>();
		if(!contrato.isPresent()) {
			throw new NotFoundException();
		}
		for(ProdutoDTO produto: produtos) {
			Produto produtoSalvo = produtoRepository.findById(produto.getId()).get();
			if(!contemProdutoNoContrato(contrato.get(), produtoSalvo)) {
				contrato.get().getProdutos().add(produtoSalvo);
				contrato.get().setProdutos(contrato.get().getProdutos());
				produtosCadastrados.add(produtoSalvo);
			}else {
				produtosNaoCadastrados.add(produto);
			}
		}
		return  Map.of(
						"produtosNaoCadastrados", produtosNaoCadastrados,
						"produtosCadastrados", produtosCadastrados, 
						"contrato", new ContratoDTO(repository.save(contrato.get()))
						);
	}
	
	private boolean contemProdutoNoContrato(Contrato contrato, Produto produto) {
		return contrato.getProdutos().contains(produto);
	}

	public void deleteProdutos(Long id, ProdutoDTO produto) throws NotFoundException  {
		Optional<Contrato> contrato = repository.findById(id);
		if(!contrato.isPresent()) {
			throw new NotFoundException();
		}
		Produto produtoSalvo = produtoRepository.findById(produto.getId()).get();
		if(contemProdutoNoContrato(contrato.get(), produtoSalvo)) {
			contrato.get().getProdutos().remove(produtoSalvo);
			repository.save(contrato.get());
		}
	}
	
}
