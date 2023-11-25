package br.com.pilares.ancontabil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.ancontabil.converter.IConverterBase;
import br.com.pilares.ancontabil.model.dto.BaseDTO;
import br.com.pilares.ancontabil.model.dto.BaseDetailsDTO;
import br.com.pilares.ancontabil.model.entities.EntityBase;
import br.com.pilares.ancontabil.model.form.FormBase;
import br.com.pilares.ancontabil.repository.BaseRepository;

public abstract class BaseService 
	<ER extends BaseRepository<E>, 
	EC extends IConverterBase<E, F, FE, D, DD>, 
	E extends EntityBase, F extends FormBase<E>, FE extends FormBase<E>, D extends BaseDTO<E, D>, DD extends BaseDetailsDTO<E>> 
	implements IBaseService<E, F, FE, D, DD>{

	private ER repository;
	private EC converter;
	
	public void beforeCreate(F form){ }
	public void afterCreate(F form, E entity){ }
	
	public BaseService(EC converter, ER repository) {
		this.converter = converter;
		this.repository = repository;
	}
		
	@Override
	public List<D> getAll() {
		return converter.ListEntityParaListDTO(repository.findByDesabilitado(false));
	}
	
	@Override
	public DD getById(Long id) throws NotFoundException {
		Optional<E> optional = repository.findById(id);
		if(optional.isPresent()) {
			return converter.entityParaDetailsDTO(optional.get());			
		}
		throw new NotFoundException();
	}
	
	@Override
	public List<E> getList(List<Long> ids) {
		return repository.findAllById(ids);
		
	}

	@Override
	public E createBase(F form) {
		beforeCreate(form);
		E entity = repository.save(converter.formParaEntity(form));
		afterCreate(form, entity);
		return entity;
	}
		
	@Override
	public DD create(F form) {
		beforeCreate(form);
		E entity = repository.save(converter.formParaEntity(form));
		afterCreate(form, entity);
		return converter.entityParaDetailsDTO(entity);
	}
	
	@Override
	public DD edit(Long id, FE formEdit) throws NotFoundException {
		Optional<E> optional = repository.findById(id);
		if(optional.isPresent()) {
			E entity = repository.save(converter.setarValoresEditar(optional.get(), formEdit));
			return converter.entityParaDetailsDTO(entity);			
		}
		throw new NotFoundException();
	}
	
	@Override
	public void disable(Long id) throws NotFoundException{
		Optional<E> entity = repository.findById(id);
		if(entity.isPresent()) {
			entity.get().setDesabilitado(true);
			repository.save(entity.get());
		}else {
			throw new NotFoundException();			
		}
	}
	
}