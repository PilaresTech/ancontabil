package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;

import br.com.pilares.ancontabil.model.entities.Produto;
import br.com.pilares.ancontabil.model.enums.TipoProduto;
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
public class ProdutoDetailsDTO extends BaseDetailsDTO<Produto> {

	private TipoProduto tipoProduto;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	
	public ProdutoDetailsDTO(Produto entity) {
		this.setDataBaseDetailsDTO(entity);
    	this.setTipoProduto(entity.getTipoProduto());
    	this.setNome(entity.getNome());
    	this.setDescricao(entity.getDescricao());
    	this.setValor(entity.getValor());    	
    }
	
}
