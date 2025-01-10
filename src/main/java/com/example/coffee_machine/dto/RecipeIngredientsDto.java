package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class RecipeIngredientsDto {
    
    private Long id;
    private Long recipeId;
    private Long ingredientId;
    private int quantity;
}
