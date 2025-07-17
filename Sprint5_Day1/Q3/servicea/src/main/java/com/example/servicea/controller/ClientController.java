package com.example.servicea.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class ClientController {

    @Value("${jwt.secret}")
    private String secret;

    @GetMapping("/consume")
    public String callServiceB() {
        String jwt = Jwts.builder()
                .setSubject("service-a")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // 10 mins
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = new RestTemplate()
                .exchange("http://localhost:8081/api/data", HttpMethod.GET, request, String.class);

        return response.getBody();
    }
}
