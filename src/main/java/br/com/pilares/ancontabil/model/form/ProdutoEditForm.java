package br.com.pilares.ancontabil.model.form;

import java.math.BigDecimal;

import br.com.pilares.ancontabil.model.entities.Produto;
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
public class ProdutoEditForm extends FormBase<Produto>{
	
	private String nome;
	private String descricao;
	private BigDecimal valor;

}
