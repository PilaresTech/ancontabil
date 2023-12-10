package br.com.pilares.ancontabil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.entities.Usuario;
import br.com.pilares.ancontabil.repository.UsuarioRepository;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String documento) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByPessoaDocumento(documento);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return (UserDetails) new UsernameNotFoundException("Dados Invalidos");
	}
	
}