package br.com.pilares.ancontabil.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pilares.ancontabil.model.entities.Contato;
import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.enums.TipoPessoa;
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
public class ContatoDTO {
	
	private String email;
	private String telefone;
	private String whatsapp;
	
	public ContatoDTO(Contato contato){
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.whatsapp = contato.getWhatsapp();
	}
	
	public static List<ContatoDTO> converter(List<Contato> contatos){
		return contatos.stream().map(ContatoDTO::new).collect(Collectors.toList());
	}

}
