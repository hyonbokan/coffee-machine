package com.example.coffee_machine.controller;

import com.example.coffee_machine.dto.ErrorResponseDto;
import com.example.coffee_machine.dto.OrderDto;
import com.example.coffee_machine.model.Order;
import com.example.coffee_machine.service.OrdersService;
import com.example.coffee_machine.utils.CoffeeMachineAvailabilityChecker;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController("/order")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService orderService;
    private final CoffeeMachineAvailabilityChecker coffeeMachineAvailabilityChecker;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestParam Long recipeId) {

        if (!coffeeMachineAvailabilityChecker.isOperational()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ErrorResponseDto(
                    "The coffee machine is not operational at this time.",
                    HttpStatus.SERVICE_UNAVAILABLE.value(),
                    LocalDateTime.now()
                ));
        }

        Order order = orderService.createOrder(recipeId);

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setRecipeId(order.getRecipe().getId());
        orderDto.setRecipeName(order.getRecipe().getName());
        orderDto.setOrderDate(order.getOrderDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }
}
