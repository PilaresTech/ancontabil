package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.pilares.ancontabil.model.form.PagamentoForm;
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
public class MPPaymentDTO {

	private String description;
	private int installments;
	private MPPayerDTO payer;
	private String payment_method_id;
	private BigDecimal transaction_amount;
	
	public MPPaymentDTO(PagamentoForm form) {
		this.description = "Payment for product";
		this.installments = 1;
		this.payer = new MPPayerDTO(form.getSolicitacao().getPessoa());
		this.payment_method_id = "pix";
		this.transaction_amount = form.getSolicitacao().getProduto().getValor().setScale(2, RoundingMode.HALF_UP);
	}
	
}
