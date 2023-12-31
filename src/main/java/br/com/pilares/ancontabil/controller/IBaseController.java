package br.com.pilares.ancontabil.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pilares.ancontabil.exception.BaseException;
import br.com.pilares.ancontabil.model.dto.BaseDTO;
import br.com.pilares.ancontabil.model.dto.BaseDetailsDTO;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;
import br.com.pilares.ancontabil.service.IBaseService;

public interface IBaseController <
	S extends IBaseService<E, F, FE, D, DD>, 
	E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D extends BaseDTO<E, D>, DD extends BaseDetailsDTO<E> >{

	List<D> get();
	DD getId(@PathVariable Long id, @PathVariable String hash) throws BaseException;
	DD post(@RequestBody F form);
	DD put(@PathVariable Long id, @RequestBody FE formEdit) throws BaseException;
	void delete(@PathVariable Long id) throws BaseException;
}