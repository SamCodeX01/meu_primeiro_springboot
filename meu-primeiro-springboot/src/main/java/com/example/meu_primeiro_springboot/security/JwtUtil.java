package com.example.meu_primeiro_springboot.security;

import java.security.Key;
import java.security.KeyStore;
import java.security.Signature;
import java.util.Date;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Security.keys;


public class JwtUtil {
    private static final Key key = KeyStore.SecretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000;

    public static String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractUseName(String token){
        return Jwts.parseBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public static boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(Key).build().parseClaimsJws(token);
            return true;
        }
        catch(JwtExeption e){
            return false;
        }
    }

}
