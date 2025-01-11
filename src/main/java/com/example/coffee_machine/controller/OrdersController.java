package com.example.coffee_machine.controller;

import com.example.coffee_machine.dto.OrderDto;
import com.example.coffee_machine.model.Order;
import com.example.coffee_machine.service.OrdersService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController("/order")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestParam Long recipeId) {
        Order order = orderService.createOrder(recipeId);

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setRecipeId(order.getRecipe().getId());
        orderDto.setRecipeName(order.getRecipe().getName());
        orderDto.setOrderDate(order.getOrderDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }
}
