package br.com.pilares.ancontabil.model.dto;

import java.time.LocalDateTime;

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
public class PessoaDetailsDTO {

	private Long id;
	private String hash;
	private TipoPessoa tipoPessoa;
	private String documento;
	private String nomeCompleto;
	private boolean desabilitado;
	private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private ContatoDTO contato;
	
    public PessoaDetailsDTO(Pessoa entity) {
    	this.id = entity.getId();
    	this.hash = entity.getHash();
    	this.tipoPessoa = entity.getTipoPessoa();
    	this.documento = entity.getDocumento();
    	this.nomeCompleto = entity.getNomeCompleto();
    	this.desabilitado = entity.isDesabilitado();
    	this.dataCadastro = entity.getDataCadastro();
    	this.dataAtualizacao = entity.getDataAtualizacao();
    	this.contato = new ContatoDTO(entity.getContato());
    }
    
}