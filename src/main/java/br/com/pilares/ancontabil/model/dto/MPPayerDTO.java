package br.com.pilares.ancontabil.model.dto;

import java.math.BigDecimal;

import br.com.pilares.ancontabil.model.entities.Pessoa;
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
public class MPPayerDTO {

	private String entity_type; //: "individual",
    private String type; //: "customer",
    private String email; //: "test_user_123@testuser.com",
    private MPIdentificationDTO identification;
    
    public MPPayerDTO(Pessoa pessoa){
    	this.entity_type = "individual";
    	this.type = "customer";
    	this.email = pessoa.getContato().getEmail();
    	this.identification = new MPIdentificationDTO(pessoa.getDocumento());
    }
	
}
