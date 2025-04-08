package com.example.clienteservice;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador REST para gerenciar clientes
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    // Construtor que injeta o repositório de clientes
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Endpoint GET para listar todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll(); // Retorna todos os clientes do banco
    }

    // Endpoint POST para criar um novo cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente); // Salva o cliente no banco e retorna o objeto salvo
    }
}
