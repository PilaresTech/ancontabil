package br.com.pilares.ancontabil.menu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuUsuarioDTO extends MenuDTO {

	public MenuUsuarioDTO() {
		super("menuUsuario", "Usuarios", "/pessoa");
	}

	
}
