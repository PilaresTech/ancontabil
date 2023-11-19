package br.com.pilares.ancontabil.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pilares.ancontabil.model.enums.TipoPessoa;
import br.com.pilares.ancontabil.model.form.PessoaFisicaForm;
import br.com.pilares.ancontabil.model.form.PessoaFisicaFormEdit;
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
public class PessoaFisica extends EntityBase {

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	
	public PessoaFisica(PessoaFisicaForm form) {
		this.tipoPessoa = form.getTipoPessoa();
		this.documento = form.getDocumento();
		this.nomeCompleto = form.getNomeCompleto();
	}
	
	public static PessoaFisica setarValoresEditar(PessoaFisica entity, PessoaFisicaFormEdit formEditar) {
		entity.setTipoPessoa(formEditar.getTipoPessoa());
		entity.setDocumento(formEditar.getDocumento());
		entity.setNomeCompleto(formEditar.getNomeCompleto());
		return entity;
	}
	
}