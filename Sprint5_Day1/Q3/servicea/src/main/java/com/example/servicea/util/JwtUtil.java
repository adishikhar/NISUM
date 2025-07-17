package com.example.servicea.util;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String serviceName) {
        return Jwts.builder()
                .setSubject(serviceName)
                .claim("role", "ROLE_MICROSERVICE")  // ROLE_ prefix is required for Spring Security
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 minutes
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }
}

