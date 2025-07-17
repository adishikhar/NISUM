package com.example.webfluxfunctional.router;



import com.example.webfluxfunctional.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello"), handler::sayHello)
                .andRoute(RequestPredicates.GET("/time"), handler::getTime);
    }
}

