package br.com.pilares.ancontabil.util;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.pilares.ancontabil.model.dto.SubjectDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {
	
	@Value("${secret}")
	private String secret;

	@PostConstruct
    public void init(){
		
    }
	
	 public Claims getAllClaimsFromToken(String token) {
		 return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token.substring(7, token.length())).getBody();
	 }
		 
	public SubjectDTO getSubject(Claims claims) {
			return new Gson().fromJson(claims.getSubject(), SubjectDTO.class);
	}
	
	public boolean isTokenExpired(String token) {
	    try {
	        if(!(Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token.substring(7, token.length())).getBody().getExpiration().getTime() > new Date().getTime()) == false) {
	            return false;
	        }
	        return true;            
        } catch (Exception e) {
            return true;
        }
    }
	
	
}
