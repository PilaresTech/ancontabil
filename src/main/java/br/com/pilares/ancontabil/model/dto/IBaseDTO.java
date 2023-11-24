package br.com.pilares.ancontabil.model.dto;

import java.util.List;

import br.com.pilares.ancontabil.model.entities.EntityBase;

public interface IBaseDTO <E extends EntityBase, D extends BaseDTO>{

	List<D> converter(List<E> entities, Class<D> classe);
	
}
