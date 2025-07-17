package com.example.webfluxfunctional.handler;



import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class HelloHandler {

    public Mono<ServerResponse> sayHello(ServerRequest request) {
        return ServerResponse.ok().bodyValue("Hello Functional");
    }

    public Mono<ServerResponse> getTime(ServerRequest request) {
        String currentTime = LocalDateTime.now().toString();
        return ServerResponse.ok().bodyValue(currentTime);
    }
}

