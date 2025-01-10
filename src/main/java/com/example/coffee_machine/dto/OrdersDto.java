package com.example.coffee_machine.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdersDto {
    private Long id;
    private Long recipeId;
    private LocalDateTime orderDate;
}
