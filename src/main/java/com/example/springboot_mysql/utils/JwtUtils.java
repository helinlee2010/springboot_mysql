package com.example.springboot_mysql.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtils {
    private String SECRET_KEY = "secret";

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public<T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String createToken(Map<String, Object> claims, String subject){
        // subject is username
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*10)) //10hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        // userDetails contain username & password
        final String tokenUsername = extractUsername(token);
        // check if token not expired & username contained in token match with that in UserDetails
        return (tokenUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
