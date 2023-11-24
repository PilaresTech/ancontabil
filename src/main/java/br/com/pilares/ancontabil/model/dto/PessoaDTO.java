package br.com.pilares.ancontabil.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.enums.TipoPessoa;
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
public class PessoaDTO extends BaseDTO<Pessoa, PessoaDTO>{

	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	private ContatoDTO contato;
	
	public PessoaDTO(Pessoa entity) {
		this.setDateBaseDTO(entity);
    	this.tipoPessoa = entity.getTipoPessoa();
    	this.documento = entity.getDocumento();
    	this.nomeCompleto = entity.getNomeCompleto();
    	this.contato = new ContatoDTO(entity.getContato());
	}
	
}