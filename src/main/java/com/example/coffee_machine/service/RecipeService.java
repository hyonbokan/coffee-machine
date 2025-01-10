package com.example.coffee_machine.service;

import org.springframework.stereotype.Service;

import com.example.coffee_machine.model.Recipe;
import com.example.coffee_machine.repository.RecipeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeService {
    
    private final RecipeRepository recipeRepository;


    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Recipe not found: " + id));
    }
}
