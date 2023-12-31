package br.com.pilares.ancontabil.model.dto;

import java.util.List;

import br.com.pilares.ancontabil.model.entities.Contato;
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
public class ContatoDTO extends BaseDTO<Contato, ContatoDTO>{
	
	private String email;
	private String telefone;
	private String whatsapp;
	
	public ContatoDTO(Contato entity){
		this.setDateBaseDTO(entity);
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
		this.whatsapp = entity.getWhatsapp();
	}
	
}