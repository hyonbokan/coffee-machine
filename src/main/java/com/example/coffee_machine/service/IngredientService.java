package com.example.coffee_machine.service;

import org.springframework.stereotype.Service;

import com.example.coffee_machine.model.Ingredient;
import com.example.coffee_machine.model.Recipe;
import com.example.coffee_machine.model.RecipeIngredient;
import com.example.coffee_machine.repository.IngredientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientService {
    
    private final IngredientRepository ingredientRepository;

    public void checkAndUpdateStock(Recipe recipe) {
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            Ingredient ingredient = recipeIngredient.getIngredient();
            int requiredQuantity = recipeIngredient.getQuantity();

            if (ingredient.getQuantity() < requiredQuantity) {
                throw new RuntimeException("Insufficient stock for " + ingredient.getName());
            }

            ingredient.setQuantity(ingredient.getQuantity() - requiredQuantity);
            ingredientRepository.save(ingredient);
        }
    }
}
