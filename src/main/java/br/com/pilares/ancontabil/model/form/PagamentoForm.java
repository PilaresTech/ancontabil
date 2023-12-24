package br.com.pilares.ancontabil.model.form;

import br.com.pilares.ancontabil.model.entities.Pagamento;
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
public class PagamentoForm extends FormBase<Pagamento>{

	private Solicitacao solicitacao;
	private String link;
	
	public PagamentoForm(Solicitacao solicitacao){
		this.solicitacao = solicitacao;
		this.link = "http://olink.com.br";
	}
}
