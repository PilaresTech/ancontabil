package br.com.pilares.ancontabil.service;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.ProdutoConverter;
import br.com.pilares.ancontabil.model.dto.ProdutoDTO;
import br.com.pilares.ancontabil.model.dto.ProdutoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.form.ProdutoEditForm;
import br.com.pilares.ancontabil.model.form.ProdutoForm;
import br.com.pilares.ancontabil.repository.ProdutoRepository;

@Service
public class ProdutoService extends BaseService<ProdutoRepository, ProdutoConverter, Produto, ProdutoForm, ProdutoEditForm, ProdutoDTO, ProdutoDetailsDTO>{

	public ProdutoService(ProdutoRepository repository, ProdutoConverter converter) {
		super(converter, repository);
	}
	
}
