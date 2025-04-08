package com.example.middleware;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador REST para gerenciar pedidos integrados
@RestController
@RequestMapping("/novosPedidos")
public class IntegratedOrdersController {

    private final IntegratedOrdersRepository IntegratedOrdersRepository;

    // Construtor que injeta o repositório de pedidos integrados
    public IntegratedOrdersController(IntegratedOrdersRepository IntegratedOrdersRepository) {
        this.IntegratedOrdersRepository = IntegratedOrdersRepository;
    }

    // Endpoint GET para listar todos os novos pedidos
    @GetMapping
    public List<IntegratedOrders> getAllNovosPedidos() {
        return IntegratedOrdersRepository.findAll(); // Retorna todos os pedidos integrados do banco
    }

    // Endpoint POST para criar um novo pedido integrado
    @PostMapping
    public IntegratedOrders createIntegratedOrders(@RequestBody IntegratedOrders IntegratedOrders) {
        return IntegratedOrdersRepository.save(IntegratedOrders); // Salva o pedido no banco e retorna o objeto salvo
    }
}
