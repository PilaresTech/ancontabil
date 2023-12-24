package br.com.pilares.ancontabil.model.form;

import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
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
public class SolicitacaoForm extends FormBase<Solicitacao>{

	private Produto produto;
	private Pessoa pessoa;
	
}
