package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class CoffeeMachineRecipeDto {
    private Long id;
    private Long coffeeMachineId;
    private Long recipeId;
}
