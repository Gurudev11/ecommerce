package com.monkmaze.ecommerce.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtUtils{
	    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	    public String generateJwtToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))  
	                .signWith(SignatureAlgorithm.HS256, secretKey)
	                .compact();
	    }

	    public String generateRefreshToken(String username) {
	        return Jwts.builder()	                .signWith(SignatureAlgorithm.HS256, secretKey)

	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) 
	                .compact();
	    }

	    public String getUsername(String token) {
	        return Jwts.parser()
	                .setSigningKey(secretKey)
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    public boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return Jwts.parser()
	                .setSigningKey(secretKey)
	                .parseClaimsJws(token)
	                .getBody()
	                .getExpiration();
	    }
	}  

