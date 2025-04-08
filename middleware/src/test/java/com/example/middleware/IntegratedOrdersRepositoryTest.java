package com.example.middleware;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IntegratedOrdersRepositoryTest {

    @Autowired
    private IntegratedOrdersRepository repository;

    @Test
    public void testSaveAndRetrieveOrder() {
        IntegratedOrders order = new IntegratedOrders();
        order.setClienteId(1L);
        order.setDescricao("Pedido Teste");
        repository.save(order);
    
        System.out.println("Pedido salvo com sucesso!");
    
        List<IntegratedOrders> orders = repository.findAll();
        System.out.println("Pedidos encontrados: " + orders.size());
        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getDescricao()).isEqualTo("Pedido Teste");
    }
    


}


