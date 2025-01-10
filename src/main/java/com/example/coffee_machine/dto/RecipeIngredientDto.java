package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class RecipeIngredientDto {
    
    private Long id;
    private Long recipeId;
    private Long ingredientId;
    private int quantity;
}
