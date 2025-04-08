package com.example.middleware;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IntegratedOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String descricao;

    public Long getId() { 
        return id; 
    } 
    public void setId(Long id) { 
        this.id = id; 
    } 
    public Long getClienteId() { 
        return clienteId; 
    } 
    public void setClienteId(Long clienteId) { 
        this.clienteId = clienteId; 
    } 
    public String getDescricao() { 
        return descricao; 
    } 
    public void setDescricao(String descricao) { 
        this.descricao = descricao;
    }    
}
