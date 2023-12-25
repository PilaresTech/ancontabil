package br.com.pilares.ancontabil.model.dto;

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
public class MPIdentificationDTO {

	private String type;
	private String number;
	
	public MPIdentificationDTO(String documento) {
		this.type = "CPF";
		this.number = documento;
	}
	
}
