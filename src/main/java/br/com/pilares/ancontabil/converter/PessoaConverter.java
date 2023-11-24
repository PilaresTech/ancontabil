package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.PessoaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.form.PessoaForm;
import br.com.pilares.ancontabil.model.form.PessoaFormEdit;

@Service
public class PessoaConverter implements IConverterBase<Pessoa, 
	PessoaForm, 
	PessoaFormEdit, 
	PessoaDTO, 
	PessoaDetailsDTO> {
	
	@Override
	public PessoaDetailsDTO entityParaDetailsDTO(Pessoa entity) {
		return new PessoaDetailsDTO(entity);
	}
	
	@Override
	public PessoaDTO entityParaDTO(Pessoa entity) {
		return new PessoaDTO(entity);
	}
	
	@Override
	public Pessoa formParaEntity(PessoaForm form) {
		return new Pessoa(form);
	}
	
	@Override
	public List<PessoaDTO> ListEntityParaListDTO(List<Pessoa> entitys) {
		PessoaDTO d = new PessoaDTO();
		return d.converter(entitys, PessoaDTO.class);
	}
	
	@Override
	public Pessoa setarValoresEditar(Pessoa entity, PessoaFormEdit formEditar) {
		return Pessoa.setarValoresEditar(entity, formEditar);
	}
	
}