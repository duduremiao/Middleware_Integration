package com.example.middleware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MiddlewareIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareIntegrationTest.class);

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        logger.info("Iniciando teste de integração para a rota '/integrate'");
    }

    @AfterEach
    public void tearDown() {
        logger.info("Teste de integração finalizado");
    }

    @Test
    public void testIntegrationRoute() throws Exception {
        logger.info("Executando requisição GET para o endpoint '/integrate'");

        mockMvc.perform(get("/integrate"))
               .andExpect(status().isOk())
               .andDo(result -> logger.info("Resposta do status: {}", result.getResponse().getStatus()));

        logger.info("Testando a resposta da requisição...");
    }
}
