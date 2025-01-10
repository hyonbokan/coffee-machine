package com.example.coffee_machine.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long recipeId;
    private String recipeName;
    private LocalDateTime orderDate;
}
