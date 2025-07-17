package com.example.webfluxdemo;


import com.example.webfluxdemo.controller.NumberController;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

public class NumberControllerTest {

    private final WebTestClient client = WebTestClient.bindToController(new NumberController()).build();

    @Test
    public void testNumberStream() {
        client.get()
                .uri("/numbers")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody()
                .as(StepVerifier::create)
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }
}

