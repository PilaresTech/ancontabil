package br.com.pilares.ancontabil.converter;

import java.util.List;

import br.com.pilares.ancontabil.model.dto.BaseDTO;
import br.com.pilares.ancontabil.model.dto.BaseDetailsDTO;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;

public interface IConverterBase<E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D extends BaseDTO<E, D>, DD extends BaseDetailsDTO<E>>{

	D entityParaDTO(E entity);
	DD entityParaDetailsDTO(E entity);
	E formParaEntity(F form);
	List<D> ListEntityParaListDTO(List<E> entitys);
	E setarValoresEditar(E entity, FE formEditar);
	
}
