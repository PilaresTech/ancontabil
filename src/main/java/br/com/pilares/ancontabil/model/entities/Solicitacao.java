package br.com.pilares.ancontabil.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.pilares.ancontabil.model.enums.StatusSolicitacao;
import br.com.pilares.ancontabil.model.form.SolicitacaoForm;
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
public class Solicitacao extends EntityBase<Solicitacao, SolicitacaoForm>{

	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Pessoa pessoa;
	@Enumerated(EnumType.STRING)
	private StatusSolicitacao status;
	@OneToMany(mappedBy = "solicitacao")
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	public Solicitacao(SolicitacaoForm form) {
		this.produto = form.getProduto();
		this.pessoa = form.getPessoa();
		this.status = StatusSolicitacao.CRIADA;		
	}
	
	public Solicitacao(Produto produto, Pessoa pessoa) {
		this.produto = produto;
		this.pessoa = pessoa;
		this.status = StatusSolicitacao.CRIADA;		
	}
	
		
}
