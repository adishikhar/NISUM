package com.nisum.Q1.config;



import com.nisum.Q1.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfig {

    @Bean
    public Greeter greeterBean() {
        return name -> "Hello from Config, " + name;
    }
}

