package com.example.coffee_machine.controller;

import com.example.coffee_machine.dto.OrdersDto;
import com.example.coffee_machine.service.OrdersService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController("/order")
@AllArgsConstructor
public class OrdersController {

    private OrdersService orderService;

    // public OrderController(OrderService orderService) {
    //     this.orderService = orderService;
    // }

    @PostMapping("/create")
    public String createOrder(@RequestBody OrdersDto orderDto) {
        // orderService.createOrder(orderDto);
        //TODO: process POST request
        return "";
    }
}
