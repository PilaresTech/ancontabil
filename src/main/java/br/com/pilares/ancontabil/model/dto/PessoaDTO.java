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
public class PessoaDTO {

	private Long id;
	private String hash;
	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	
	public PessoaDTO(Pessoa entity) {
		this.id = entity.getId();
    	this.hash = entity.getHash();
    	this.tipoPessoa = entity.getTipoPessoa();
    	this.documento = entity.getDocumento();
    	this.nomeCompleto = entity.getNomeCompleto();
	}
	
	public static List<PessoaDTO> converter(List<Pessoa> pessoas){
		return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
	}
	
}
