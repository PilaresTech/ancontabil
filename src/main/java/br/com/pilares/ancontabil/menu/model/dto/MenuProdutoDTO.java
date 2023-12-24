package br.com.pilares.ancontabil.menu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuProdutoDTO extends MenuDTO {
	
	public MenuProdutoDTO() {
		super("menuProduto", "Produtos", "/produto");
	}

}
