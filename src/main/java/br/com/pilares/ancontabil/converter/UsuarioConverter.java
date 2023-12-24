package br.com.pilares.ancontabil.converter;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.UsuarioDTO;
import br.com.pilares.ancontabil.model.dto.UsuarioDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Usuario;
import br.com.pilares.ancontabil.model.form.UsuarioForm;

@Service
public class UsuarioConverter implements IConverterBase<Usuario,
	UsuarioForm,
	UsuarioForm,
	UsuarioDTO,
	UsuarioDetailsDTO> {

	@Override
	public UsuarioDetailsDTO entityParaDetailsDTO(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UsuarioDTO entityParaDTO(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuario formParaEntity(UsuarioForm form) {
		return new Usuario(form);
	}
	
	@Override
	public List<UsuarioDTO> ListEntityParaListDTO(List<Usuario> entitys) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuario setarValoresEditar(Usuario entity, UsuarioForm formEditar) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
