package br.com.pilares.ancontabil.model.form;

import java.math.BigDecimal;
import java.util.List;

import br.com.pilares.ancontabil.model.entities.Contrato;
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
public class ContratoForm extends FormBase<Contrato>{

	private String titulo;
	private BigDecimal valorMensal;
	
}