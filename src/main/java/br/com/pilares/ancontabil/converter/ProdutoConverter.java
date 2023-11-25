package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.ProdutoDTO;
import br.com.pilares.ancontabil.model.dto.ProdutoDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.form.ProdutoEditForm;
import br.com.pilares.ancontabil.model.form.ProdutoForm;

@Service
public class ProdutoConverter implements IConverterBase<Produto, ProdutoForm, ProdutoEditForm, ProdutoDTO, ProdutoDetailsDTO> {

	@Override
	public ProdutoDetailsDTO entityParaDetailsDTO(Produto entity) {
		return new ProdutoDetailsDTO(entity);
	}
	
	@Override
	public ProdutoDTO entityParaDTO(Produto entity) {
		return new ProdutoDTO(entity);
	}
	
	@Override
	public Produto formParaEntity(ProdutoForm form) {
		return new Produto(form);
	}
	
	@Override
	public List<ProdutoDTO> ListEntityParaListDTO(List<Produto> entitys) {
		return new ProdutoDTO().converter(entitys, ProdutoDTO.class);
	}
	
	@Override
	public Produto setarValoresEditar(Produto entity, ProdutoEditForm formEditar) {
		return new Produto().setarValoresEditar(entity, formEditar);
	}
	
}
