package br.com.pilares.ancontabil.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;

public interface IBaseService<E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D, DD> {

	List<D> getAll();
	DD getById(Long id) throws NotFoundException;
	E createBase(F form);
	DD create(F form);
	DD edit(Long id, FE formEdit) throws NotFoundException;
	void disable(Long id) throws NotFoundException;
	
}
