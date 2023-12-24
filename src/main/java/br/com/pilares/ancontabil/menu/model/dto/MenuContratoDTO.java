package br.com.pilares.ancontabil.menu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuContratoDTO extends MenuDTO {

	public MenuContratoDTO() {
		super("menuContrato", "Contratos", "/contrato");
	}
	
}
