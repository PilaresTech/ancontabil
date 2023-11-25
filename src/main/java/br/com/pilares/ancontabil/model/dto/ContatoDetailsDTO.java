package br.com.pilares.ancontabil.model.dto;

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
public class ContatoDetailsDTO extends BaseDetailsDTO<Contato> {

	private String email;
	private String telefone;
	private String whatsapp;
	
	public ContatoDetailsDTO(Contato contato){
		this.setDataBaseDetailsDTO(contato);
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.whatsapp = contato.getWhatsapp();
	}
	
}
