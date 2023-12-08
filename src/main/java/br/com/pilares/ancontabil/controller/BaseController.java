package br.com.pilares.ancontabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.exception.BaseException;
import br.com.pilares.ancontabil.factory.IBaseFactory;
import br.com.pilares.ancontabil.model.dto.BaseDTO;
import br.com.pilares.ancontabil.model.dto.BaseDetailsDTO;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;
import br.com.pilares.ancontabil.service.IBaseService;
import br.com.pilares.ancontabil.util.MessageSourceUtil;

@RestController
public abstract class BaseController<
	S extends IBaseService<E, F, FE, D, DD>, 
	E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D extends BaseDTO<E, D>, DD extends BaseDetailsDTO<E>>
	implements IBaseController<
	S, E, F, FE, D, DD>{
	
	private S service;
		
	public BaseController(S service) {
		this.service = service;
	}
	
	@GetMapping
	@Override
	public List<D> get() {
		return service.getAll();
	}
	
	@GetMapping("/{id}/{hash}")
	@Override
	public DD getId(Long id, String hash) throws BaseException {
		return service.getByIdAndHash(id, hash);
	}
	
	@PostMapping
	@Override
	public DD post(F form) {
		return service.create(form);
	}
	
	@PutMapping("/{id}")
	@Override
	public DD put(Long id, FE formEdit) throws BaseException {
		return service.edit(id, formEdit);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(Long id) throws BaseException {
		service.disable(id);
	}
	
}
