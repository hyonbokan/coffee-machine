package com.example.coffee_machine.dto;

import java.util.List;

import lombok.Data;

@Data
public class RecipeDto {
    private String name;
    private List<IngredientDto> ingredients;
}
