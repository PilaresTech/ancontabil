package br.com.pilares.ancontabil.menu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuSolicitacaoDTO extends MenuDTO {

	public MenuSolicitacaoDTO() {
		super("menuSolicitacao", "Solicitações", "/solicitacao");
	}
}
