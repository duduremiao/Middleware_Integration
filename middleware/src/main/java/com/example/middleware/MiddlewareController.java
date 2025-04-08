package com.example.middleware;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador para iniciar a integração entre serviços
@RestController
public class MiddlewareController {

    @Autowired
    private ProducerTemplate producerTemplate; // Template para iniciar a rota Camel

    // Endpoint GET para iniciar a integração
    @GetMapping("/integrate")
    public String integrateServices() {
        // Envia mensagem para a rota "direct:integrateClientsOrders"
        return producerTemplate.requestBody("direct:integrateClientsOrders", null, String.class);
    }
}
