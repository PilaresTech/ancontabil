package br.com.pilares.ancontabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.model.form.LoginForm;
import br.com.pilares.ancontabil.service.AuthService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

	private AuthService authService;
	
	@Autowired
	public LoginController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody LoginForm form){
		return authService.login(form);
	}
	
}
