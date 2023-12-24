package br.com.pilares.ancontabil.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.com.pilares.ancontabil.model.enums.StatusPagamento;
import br.com.pilares.ancontabil.model.form.PagamentoForm;
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
public class Pagamento extends EntityBase<Pagamento, PagamentoForm>{
	
	@Transient
	protected BigDecimal DIVISAO = new BigDecimal("2");

	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	@ManyToOne
	private Solicitacao solicitacao;
	private String link;
	
	public Pagamento(PagamentoForm form){
		this.valor = form.getSolicitacao().getProduto().getValor().divide(DIVISAO);
		this.status = StatusPagamento.CRIADO;
		this.solicitacao = form.getSolicitacao();
		this.link = form.getLink();
	}
	
	public String getContato() {
		return this.solicitacao.getPessoa().getContato().getWhatsapp();
	}
	
}
