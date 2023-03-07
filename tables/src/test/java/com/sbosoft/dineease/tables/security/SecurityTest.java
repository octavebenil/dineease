package com.sbosoft.dineease.tables.security;

import com.sbosoft.dineease.tables.TablesApplication;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@ContextConfiguration(classes = TablesApplication.class)
public class SecurityTest {

    @Autowired
    ApplicationContext context;

    WebTestClient webTestClient;

    @Before(value = "")
    public void setup(){
        this.webTestClient = WebTestClient
                .bindToApplicationContext(this.context)
                .configureClient()
                .build();
    }

    @Test
    void whenNoCreadentials_thenRedirectToLogin(){
        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus().is3xxRedirection();
    }
}
