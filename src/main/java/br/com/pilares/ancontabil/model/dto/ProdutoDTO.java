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
public class ProdutoDTO extends BaseDTO<Produto, ProdutoDTO> {
	
	private Long id;
	private String hash;
	private TipoProduto tipoProduto;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	
	public ProdutoDTO(Produto entity) {
    	this.id = entity.getId();
    	this.hash = entity.getHash();
    	this.tipoProduto = entity.getTipoProduto();
    	this.nome = entity.getNome();
    	this.descricao = entity.getDescricao();
    	this.valor = entity.getValor();
    }
	
}
