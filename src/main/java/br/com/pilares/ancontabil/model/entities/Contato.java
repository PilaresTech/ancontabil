package br.com.pilares.ancontabil.model.entities;

import javax.persistence.Entity;

import br.com.pilares.ancontabil.model.form.ContatoForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Contato extends EntityBase<Contato, ContatoForm>{

	private String email;
	private String telefone;
	private String whatsapp;
	
	public Contato(ContatoForm form){
		this.email = form.getEmail();
		this.telefone = form.getTelefone();
		this.whatsapp = form.getWhatsapp();
	}
	
	@Override
	public Contato setarValoresEditar(Contato entity, ContatoForm formEditar) {
		entity.setEmail(formEditar.getEmail());
		entity.setTelefone(formEditar.getTelefone());
		entity.setWhatsapp(formEditar.getWhatsapp());
		return entity;
	}
}
