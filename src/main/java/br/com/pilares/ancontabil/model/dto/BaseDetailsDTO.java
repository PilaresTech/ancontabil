package br.com.pilares.ancontabil.model.dto;

import java.time.LocalDateTime;

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
public class BaseDetailsDTO<E extends EntityBase> {

	private Long id;
	private String hash;
	private boolean desabilitado;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	
	public void setDataBaseDetailsDTO(E entity) {
		this.setId(entity.getId());
    	this.setHash(entity.getHash());
    	this.setDesabilitado(entity.isDesabilitado());
    	this.setDataCadastro(entity.getDataCadastro());
    	this.setDataAtualizacao(entity.getDataAtualizacao());
	}
	
}
