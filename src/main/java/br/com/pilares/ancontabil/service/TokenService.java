package br.com.pilares.ancontabil.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pilares.ancontabil.model.dto.SubjectDTO;
import br.com.pilares.ancontabil.model.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${expiration}")
	private String expiration;
	@Value("${secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date dataExpiracao = new Date(new Date().getTime() + Long.parseLong(expiration));
		String sub = mapper.writeValueAsString(
				new SubjectDTO(
						logado.getPessoa().getId(), 
						logado.getPessoa().getHash(),
						logado.getPerfis()
						)
				);
		return Jwts.builder()
					.setIssuer("token Jwt")
					.setSubject(logado.getId().toString())
					.setIssuedAt(new Date())
					.setExpiration(dataExpiracao)
					.signWith(SignatureAlgorithm.HS256, secret).compact();		
	}
	
	public boolean isTokenValid(String token) {
		System.out.println("isTokenValid");
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		}catch (Exception e) {
			return false;
		}
	}	
	
	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		//SubjectDTO sub = (SubjectDTO) claims.getSubject();
		return Long.parseLong(claims.getSubject());
	}
}
