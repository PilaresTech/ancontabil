package br.com.pilares.ancontabil.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;
import br.com.pilares.ancontabil.service.IBaseService;

public interface IBaseController <
	S extends IBaseService<E, F, FE, D, DD>, 
	E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D, DD >{

	List<D> get();
	DD getId(@PathVariable Long id) throws NotFoundException;
	DD post(@RequestBody F form);
	DD put(@PathVariable Long id, @RequestBody FE formEdit) throws NotFoundException;
	void delete(@PathVariable Long id) throws NotFoundException;
}