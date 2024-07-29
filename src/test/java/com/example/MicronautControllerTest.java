package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class MicronautControllerTest {
    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void shouldBeAbleToGetGreeting() {
        HttpRequest<?> request = HttpRequest.GET("/greeting")
                .uri(builder ->
                        builder.queryParam("name", "Micronaut")
                                .build()
                ).accept(MediaType.TEXT_PLAIN);
        String body = httpClient.toBlocking().exchange(request).toString();
        assertNotNull(body);
    }
}
