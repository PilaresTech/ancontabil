package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;

import br.com.pilares.ancontabil.model.entities.Pagamento;
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
public class PagamentoDTO extends BaseDTO<Pagamento, PagamentoDTO>{
	
	private BigDecimal valor;
	private StatusPagamento status;
	
	public PagamentoDTO(Pagamento entity){
		this.setDateBaseDTO(entity);
		this.valor = entity.getValor();
		this.status = entity.getStatus();
	}

}
