package br.com.pilares.ancontabil.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ServerWebExchange;

import br.com.pilares.ancontabil.model.dto.SubjectDTO;
import br.com.pilares.ancontabil.model.entities.Perfil;
import br.com.pilares.ancontabil.model.entities.Usuario;
import br.com.pilares.ancontabil.repository.UsuarioRepository;
import br.com.pilares.ancontabil.service.TokenService;
import br.com.pilares.ancontabil.util.JWTUtil;
import io.jsonwebtoken.Claims;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTUtil jwtUtil;
	
	private TokenService tokenService;
	
	private UsuarioRepository usuarioRepository;
	
	public AuthenticationFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.tokenService = tokenService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValid(token);
		if (valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);
		
	}
	
	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token==null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		System.out.println(token);
		return token.substring(7, token.length());
	}

	private void populateRequestWithHeaders(ServerWebExchange exchange, Claims claims) {
		 SubjectDTO sub = jwtUtil.getSubject(claims);
		 exchange.getRequest().mutate()
	        		.header("id", sub.getId().toString())
	        		.header("hash", sub.getHash())
	                .header("role", Perfil.getPerfis(sub.getPerfis()))
	                .build();
	}
	
	private String getAuthHeader(ServerHttpRequest request) {
		return request.getHeaders().getOrEmpty("Authorization").get(0);
	}
	 
	private boolean isAuthMissing(ServerHttpRequest request) {
		return !request.getHeaders().containsKey("Authorization");
	}
	
}
