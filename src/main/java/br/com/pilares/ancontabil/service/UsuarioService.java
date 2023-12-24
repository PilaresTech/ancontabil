package br.com.pilares.ancontabil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.UsuarioConverter;
import br.com.pilares.ancontabil.model.dto.UsuarioDTO;
import br.com.pilares.ancontabil.model.dto.UsuarioDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Perfil;
import br.com.pilares.ancontabil.model.entities.Usuario;
import br.com.pilares.ancontabil.model.form.UsuarioForm;
import br.com.pilares.ancontabil.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<
	UsuarioRepository,
	UsuarioConverter,
	Usuario,
	UsuarioForm,
	UsuarioForm,
	UsuarioDTO,
	UsuarioDetailsDTO
	>{

	@Autowired
	public UsuarioService(UsuarioConverter converter, UsuarioRepository repository) {
		super(converter, repository);
	}
	
	@Override
	public void afterCreate(UsuarioForm form, Usuario entity) {
		entity.setPerfis(List.of(new Perfil(2L, "COMUM")));
		reSave(entity);
	}
	
}
