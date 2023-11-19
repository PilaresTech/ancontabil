package br.com.pilares.ancontabil.converter;

import java.util.List;

public interface ConverterBase<E, F, FE, D, DD>{

	D entityParaDTO(E entity);
	DD entityParaDetailsDTO(E entity);
	E formParaEntity(F form);
	List<D> ListEntityParaListDTO(List<E> entitys);
	E setarValoresEditar(E entity, FE formEditar);
	
}
