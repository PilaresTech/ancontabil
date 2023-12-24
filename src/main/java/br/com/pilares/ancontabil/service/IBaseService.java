package br.com.pilares.ancontabil.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.pilares.ancontabil.exception.BaseException;
import br.com.pilares.ancontabil.model.dto.BaseDTO;
import br.com.pilares.ancontabil.model.dto.BaseDetailsDTO;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;

public interface IBaseService<E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D extends BaseDTO<E, D>, DD extends BaseDetailsDTO<E>> {

	List<D> getAll();
	DD getByIdAndHash(Long id, String hash) throws BaseException;
	List<E> getList(List<Long> ids);
	E createBase(F form);
	DD create(F form);
	DD edit(Long id, FE formEdit) throws BaseException;
	void disable(Long id) throws BaseException;
	E reSave(E entity);
	
}
