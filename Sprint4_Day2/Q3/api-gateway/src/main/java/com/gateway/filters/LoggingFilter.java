package com.gateway.filters;



import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class LoggingFilter implements GatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getPath().toString();
            System.out.println("[LOG] Request path: " + path + " at " + LocalDateTime.now());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Optionally log after response
            }));
        };
    }

    @Override
    public Class<Object> getConfigClass() {
        return Object.class;
    }

    @Override
    public Object newConfig() {
        return new Object();
    }
}
