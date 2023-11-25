package br.com.pilares.ancontabil.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.pilares.ancontabil.model.form.ContratoForm;
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
public class Contrato extends EntityBase<Contrato, ContratoForm>{

	private String titulo;
	private BigDecimal valorMensal;
	@ManyToMany
	@JoinTable(name = "contrato_produtos", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos = new ArrayList<>();
	
	public Contrato(ContratoForm form) {
		this.titulo = form.getTitulo();
		this.valorMensal = form.getValorMensal();		
	}
	
	@Override
	public  Contrato setarValoresEditar(Contrato entity, ContratoForm formEditar) {
		entity.setTitulo(formEditar.getTitulo());
		entity.setValorMensal(formEditar.getValorMensal());
		return entity;
	}
	
}
