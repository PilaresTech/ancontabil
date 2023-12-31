package br.com.pilares.ancontabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.converter.PessoaConverter;
import br.com.pilares.ancontabil.model.dto.PessoaDTO;
import br.com.pilares.ancontabil.model.dto.PessoaDetailsDTO;
import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.model.entities.Usuario;
import br.com.pilares.ancontabil.model.form.PessoaForm;
import br.com.pilares.ancontabil.model.form.PessoaFormEdit;
import br.com.pilares.ancontabil.model.form.UsuarioForm;
import br.com.pilares.ancontabil.repository.PessoaRepository;
import br.com.pilares.ancontabil.repository.UsuarioRepository;

@Service
public class PessoaService extends BaseService<PessoaRepository, PessoaConverter, Pessoa, PessoaForm, PessoaFormEdit, PessoaDTO, PessoaDetailsDTO> {

	public PessoaService(PessoaConverter converter, PessoaRepository repository) {
		super(converter, repository);
	}	
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void beforeCreate(PessoaForm form) {
		form.getContato().setEntity(contatoService.createBase(form.getContato()));
	}
	
	@Override
	public void afterCreate(PessoaForm form, Pessoa entity) {
		usuarioService.reSave(new Usuario(new UsuarioForm(entity, entity.getDocumento())));
	}
	
}