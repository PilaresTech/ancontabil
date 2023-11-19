package br.com.pilares.ancontabil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.ConverterBase;
import br.com.pilares.ancontabil.model.entities.EntityBase;

public abstract class BaseService 
	<ER extends JpaRepository<E, Long>, 
	EC extends ConverterBase<E, F, FE, D, DD>, 
	E extends EntityBase, F, FE, D, DD> 
	implements IBaseService<E, F, FE, D, DD>{

	private ER repository;
	private EC converter;
	
	public BaseService(EC converter, ER repository) {
		this.converter = converter;
		this.repository = repository;
	}
	
	@Override
	public List<D> getAll() {
		return converter.ListEntityParaListDTO(repository.findAll());
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
	public DD create(F form) {
		E entity = repository.save(converter.formParaEntity(form));
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