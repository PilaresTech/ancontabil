package br.com.pilares.ancontabil.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import br.com.pilares.ancontabil.converter.ContatoConverter;
import br.com.pilares.ancontabil.model.enums.TipoPessoa;
import br.com.pilares.ancontabil.model.form.PessoaForm;
import br.com.pilares.ancontabil.model.form.PessoaFormEdit;
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
public class Pessoa extends EntityBase<Pessoa, PessoaFormEdit> {

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	@ManyToOne
	private Contato contato;
	
	public Pessoa(PessoaForm form) {
		this.tipoPessoa = form.getTipoPessoa();
		this.documento = form.getDocumento();
		this.nomeCompleto = form.getNomeCompleto();
		this.contato = form.getContato().getEntity();
	}
	
	public Pessoa setarValoresEditar(Pessoa entity, PessoaFormEdit formEditar) {
		entity.setTipoPessoa(formEditar.getTipoPessoa());
		entity.setDocumento(formEditar.getDocumento());
		entity.setNomeCompleto(formEditar.getNomeCompleto());
		return entity;
	}
	
}