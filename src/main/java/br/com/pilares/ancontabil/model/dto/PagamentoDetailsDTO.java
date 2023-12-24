package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.pilares.ancontabil.model.entities.Contrato;
import br.com.pilares.ancontabil.model.entities.Pagamento;
import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.enums.StatusPagamento;
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
public class PagamentoDetailsDTO extends BaseDetailsDTO<Pagamento>{

	private BigDecimal valor;
	private StatusPagamento status;
	private SolicitacaoDTO solicitacao;
	
	public PagamentoDetailsDTO(Pagamento entity) {
		this.valor = entity.getValor();
		this.status = entity.getStatus();
		this.solicitacao = new SolicitacaoDTO(entity.getSolicitacao());
	}
	
}
