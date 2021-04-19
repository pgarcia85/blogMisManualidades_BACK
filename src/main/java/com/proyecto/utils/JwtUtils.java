package com.proyecto.utils;

import java.util.Date;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;









import com.proyecto.service.UserDetailsImpl;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Value("${blog.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${blog.app.jwtExpirationsMs}")
	private int jwtExpirationsMs;
	
	public String generateToken(Authentication authentication){
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	return Jwts.builder()
			.setSubject(userPrincipal.getUsername())
			.setIssuedAt(new Date())
			.setExpiration(new Date(new Date().getTime()+ jwtExpirationsMs))
	.signWith(SignatureAlgorithm.HS512, jwtSecret)
	.compact();
	}
	
	public String getUserNameFomJwsToken(String token){
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String token){
		try{
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
			
		}catch(SignatureException e){
			logger.error("Invalid Jwt signature:", e.getMessage());
		}catch(MalformedJwtException e){
			logger.error("Invalid Jwt token:", e.getMessage());
		}catch(ExpiredJwtException e){
			logger.error("Jwt token is expired:", e.getMessage());
		}catch(UnsupportedJwtException e){
			logger.error("Jwt token is unsupported:", e.getMessage());
		}catch(IllegalArgumentException e){
			logger.error("Jwt claims is empty:", e.getMessage());
		}
		return false;
	}
}
