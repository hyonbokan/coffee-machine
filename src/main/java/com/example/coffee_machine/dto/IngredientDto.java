package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private int quantity;
}
