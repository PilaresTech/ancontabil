package br.com.pilares.ancontabil.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pilares.ancontabil.model.entities.Solicitacao;
import br.com.pilares.ancontabil.model.enums.StatusSolicitacao;
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
public class SolicitacaoDTO extends BaseDTO<Solicitacao, SolicitacaoDTO>{
	
	private ProdutoDTO produto;
	private PessoaDTO pessoa;
	private StatusSolicitacao status;
	private List<PagamentoDTO> pagamentos = new ArrayList<>();
	
	public SolicitacaoDTO(Solicitacao solicitacao) {
		this.setDateBaseDTO(solicitacao);
		this.produto = new ProdutoDTO(solicitacao.getProduto());
		this.pessoa = new PessoaDTO(solicitacao.getPessoa());
		this.status = solicitacao.getStatus();
		this.pagamentos = new PagamentoDTO().converter(solicitacao.getPagamentos(), PagamentoDTO.class);
	}

}
