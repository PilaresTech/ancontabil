package br.com.pilares.ancontabil.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pilares.ancontabil.model.entities.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO<E extends EntityBase, D extends BaseDTO> implements IBaseDTO<E, D>{

	private Long id;
	private String hash;
	
	public void setDateBaseDTO(E entity) {
		this.setId(entity.getId());
    	this.setHash(entity.getHash());
	}
	
	@Override
	public List<D> converter(List<E> entities, Class<D> classe) {
		return entities.stream().map(entity -> mapEntity(entity, classe)).collect(Collectors.toList());
	}
	
	private static <D, E> D mapEntity(E entity, Class<D> classe) {
		try {
			return classe.getDeclaredConstructor(entity.getClass()).newInstance(entity);
		} catch (Exception  e) {
			throw new RuntimeException("Erro ao mapear entidade para DTO", e);
		} 
	}
	
}
