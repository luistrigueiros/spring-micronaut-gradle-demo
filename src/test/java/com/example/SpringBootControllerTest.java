package com.example;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootControllerTest {
    @Inject
    private WebTestClient webTestClient;

    @Test
    void shouldBeAbleToGetGreeting() {
        webTestClient.get().
                uri(builder -> builder
                        .path("/greeting")
                        .queryParam("message", "Luis")
                        .build())
                .exchange()
                .expectStatus()
                .isOk();
    }
}
