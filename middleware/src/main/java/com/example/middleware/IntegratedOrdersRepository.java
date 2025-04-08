package com.example.middleware;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegratedOrdersRepository  extends JpaRepository<IntegratedOrders, Long>{
    
}
