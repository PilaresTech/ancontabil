package br.com.pilares.ancontabil.model.form;

import br.com.pilares.ancontabil.model.entities.Contato;
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
public class ContatoForm extends FormBase<Contato> {

	private String email;
	private String telefone;
	private String whatsapp;
	
}
