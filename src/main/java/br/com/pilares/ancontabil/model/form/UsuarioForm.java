package br.com.pilares.ancontabil.model.form;

import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm extends FormBase<Usuario>{

	private Pessoa pessoa;
	private String senha;
	
}
