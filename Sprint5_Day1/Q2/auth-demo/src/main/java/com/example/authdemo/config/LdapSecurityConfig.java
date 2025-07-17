package com.example.authdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2) // Lower priority than DAO config
public class LdapSecurityConfig {

    @Bean
    public SecurityFilterChain ldapFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/ldap/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().fullyAuthenticated()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setUrl("ldap://localhost:8389/");
        source.setBase("dc=springframework,dc=org");
        return source;
    }

    @Bean
    public AuthenticationManager ldapAuthManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .contextSource(contextSource())
                .and()
                .build();
    }
}

