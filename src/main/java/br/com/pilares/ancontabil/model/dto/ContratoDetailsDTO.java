package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.pilares.ancontabil.model.entities.Contrato;
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
public class ContratoDetailsDTO extends BaseDetailsDTO<Contrato>{

	private String titulo;
	private BigDecimal valorMensal;
	private List<ProdutoDTO> produtos;
	
	
	public ContratoDetailsDTO(Contrato entity) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		this.setDataBaseDetailsDTO(entity);
		this.setTitulo(entity.getTitulo());
		this.setValorMensal(entity.getValorMensal());
		this.setProdutos(produtoDTO.converter(entity.getProdutos(), ProdutoDTO.class));
	}
	
}
