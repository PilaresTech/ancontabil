package br.com.pilares.ancontabil.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pilares.ancontabil.model.entities.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
	
	private Long id;
	private String hash;
	private List<Perfil> perfis = new ArrayList<>();

}