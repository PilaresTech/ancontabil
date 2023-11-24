package br.com.pilares.ancontabil.model.dto;

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
public class PessoaDetailsDTO extends BaseDetailsDTO<Pessoa> {

	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
    private ContatoDTO contato;
	
    public PessoaDetailsDTO(Pessoa entity) {
    	this.setDataBaseDetailsDTO(entity);
    	this.setTipoPessoa(entity.getTipoPessoa());
    	this.setDocumento(entity.getDocumento());
    	this.setNomeCompleto(entity.getNomeCompleto());
    	this.setContato(new ContatoDTO(entity.getContato()));
    }
    
}