package com.eryckavel.planup.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String chaveSecreta;
    @Value("${jwt.expiration}")
    private Long duracao;

    public String gerarToken(String email, Long idUsuario){
        return Jwts.builder()
                .setSubject(email)
                .claim("idUsuario", idUsuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (duracao * 60 * 1000)))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailDoToken(String token){
        return obterClaims(token).getSubject();
    }

    public Long getIdUsuarioDoToken(String token){
        return obterClaims(token).get("idUsuario", Long.class);
    }

    private Claims obterClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validarToken(String token, String username){
        return (obterClaims(token).getSubject().equals(username)) && !isTokenExpired(token);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return obterClaims(token).getExpiration();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(chaveSecreta);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
