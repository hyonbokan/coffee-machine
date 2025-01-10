package com.example.coffee_machine.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffee_machine.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByRecipeId(Long recipeId);

    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
}