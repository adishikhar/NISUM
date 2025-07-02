package com.nisum.Q1.autoconfig;



import com.nisum.Q1.Greeter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(Greeter.class)
    public Greeter greeterAutoBean() {
        return name -> "Hello from AutoConfig, " + name;
    }
}

