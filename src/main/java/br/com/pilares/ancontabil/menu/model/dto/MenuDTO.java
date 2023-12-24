package br.com.pilares.ancontabil.menu.model.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class MenuDTO {
	
	private String id;
	private String label;
	private String rota;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuDTO(String id, String label, String rota) {
		super();
		this.id = id;
		this.label = label;
		this.rota = rota;
	}
	
	public Set<MenuDTO> listar(){
		Set<MenuDTO> menu = new HashSet<MenuDTO>();
		menu.add(new MenuProdutoDTO());
		menu.add(new MenuUsuarioDTO());
		menu.add(new MenuContratoDTO());
		menu.add(new MenuSolicitacaoDTO());
		return menu;
	}
}
