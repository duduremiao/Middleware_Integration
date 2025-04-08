package com.example.middleware;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

// Define as rotas de integração utilizando Apache Camel
@Component
public class IntegrationRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Tratamento global de exceções
        onException(Exception.class)
            .log("Exception occurred: ${exception.message}") // Loga a exceção
            .handled(true); // Marca a exceção como tratada

        // Rota principal para integrar clientes e pedidos
        from("direct:integrateClientsOrders")
            .log("Processing request for clients and orders...")

            // Faz requisição para o serviço de clientes
            .to("http://localhost:8081/clientes")
            .log("ClienteService response: ${body}")

            // Divide a resposta de clientes e processa cada cliente individualmente
            .split().jsonpath("$[*]")
            .setHeader("clienteId", simple("${body[id]}")) // Define cabeçalho com ID do cliente
            .setHeader("clienteNome", simple("${body[nome]}")) // Define cabeçalho com nome do cliente

            // Faz requisição para o serviço de pedidos utilizando clienteId
            .toD("http://localhost:8082/pedidos?query=clienteId=${header.clienteId}")
            .log("PedidoService response for clienteId ${header.clienteId}: ${body}")

            // Verifica se há pedidos para o cliente
            .choice()
                .when().jsonpath("$[?(@.clienteId == ${header.clienteId})]") // Confere pedidos válidos
                    .unmarshal().json(JsonLibrary.Jackson) // Converte JSON para objeto Java
                    .log("Pedidos JSON para cliente ${header.clienteId}: ${body}")

                    // Itera sobre cada pedido
                    .split().jsonpath("$[*]")
                    .choice()
                        .when().jsonpath("$[?(@.clienteId == ${header.clienteId})]") // Confere clienteId
                            .setBody(simple(
                                "{\"clienteId\": \"${header.clienteId}\", \"descricao\": \"Pedido para ${header.clienteNome} - ${body[descricao]}\"}"
                            )) // Formata o corpo com cliente e descrição do pedido

                            // Envia o pedido formatado para o endpoint de novosPedidos
                            .to("http://localhost:8083/novosPedidos")
                            .log("NovoPedido response: ${body}")
                        .otherwise()
                            .log("Pedido inválido para clienteId ${header.clienteId}")
                    .endChoice()
                .otherwise()
                    .log("Nenhum pedido encontrado para clienteId ${header.clienteId}")
            .end();
    }
}
