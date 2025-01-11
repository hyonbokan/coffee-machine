package com.example.coffee_machine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee_machine.dto.OrderDto;
import com.example.coffee_machine.utils.CoffeeMachineAvailabilityChecker;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class CoffeeMachineController {

    private final CoffeeMachineAvailabilityChecker availabilityChecker;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        if (!availabilityChecker.isOperational()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("The coffee machine is not operational at this time.");
        }

        // Process order
        return ResponseEntity.ok("Order created successfully!");
    }
}