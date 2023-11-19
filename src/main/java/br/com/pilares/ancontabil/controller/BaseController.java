package br.com.pilares.ancontabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.factory.IBaseFactory;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.service.IBaseService;

@RestController
public abstract class BaseController<
	S extends IBaseService<E, F, FE, D, DD>, 
	E extends EntityBase, F, FE, D, DD>
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
	
	@GetMapping("/{id}")
	@Override
	public DD getId(Long id) throws NotFoundException {
		return service.getById(id);
	}
	
	@PostMapping
	@Override
	public DD post(F form) {
		return service.create(form);
	}
	
	@PutMapping("/{id}")
	@Override
	public DD put(Long id, FE formEdit) throws NotFoundException {
		return service.edit(id, formEdit);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(Long id) throws NotFoundException {
		service.disable(id);
	}
	
}
