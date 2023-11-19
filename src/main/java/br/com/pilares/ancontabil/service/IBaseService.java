package br.com.pilares.ancontabil.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.pilares.ancontabil.model.entities.EntityBase;

public interface IBaseService<E extends EntityBase, F, FE, D, DD> {

	List<D> getAll();
	DD getById(Long id) throws NotFoundException;
	DD create(F form);
	DD edit(Long id, FE formEdit) throws NotFoundException;
	void disable(Long id) throws NotFoundException;
	
}
