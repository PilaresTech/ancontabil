package br.com.pilares.ancontabil.model.entities;

import java.math.BigDecimal;
import java.text.Normalizer.Form;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pilares.ancontabil.model.enums.TipoProduto;
import br.com.pilares.ancontabil.model.form.ProdutoEditForm;
import br.com.pilares.ancontabil.model.form.ProdutoForm;
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
public class Produto extends EntityBase {

	@Enumerated(EnumType.STRING)
	private TipoProduto tipoProduto;
	private String nome;
	private String descricao;
	private BigDecimal valor;

	public Produto(ProdutoForm form) {
		this.tipoProduto = form.getTipoProduto();
		this.nome = form.getNome();
		this.descricao = form.getDescricao();
		this.valor = form.getValor();
	}
	
	public static Produto setarValoresEditar(Produto entity, ProdutoEditForm formEditar) {
		entity.setNome(formEditar.getNome());
		entity.setDescricao(formEditar.getDescricao());
		entity.setValor(formEditar.getValor());
		return entity;
	}
	
}
