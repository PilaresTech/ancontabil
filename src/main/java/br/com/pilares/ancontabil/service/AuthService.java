package br.com.pilares.ancontabil.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.model.dto.TokenDTO;
import br.com.pilares.ancontabil.model.form.LoginForm;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	public ResponseEntity<?> login(LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(Map.of(
					"message", "Usuário não encontrado",
					"error", e.getMessage()
			));
		}
		
	}
	
}
