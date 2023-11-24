package br.com.pilares.ancontabil.model.form;

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
public class PessoaFormEdit extends FormBase<Pessoa>{

	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	private ContatoForm contato;
	
}