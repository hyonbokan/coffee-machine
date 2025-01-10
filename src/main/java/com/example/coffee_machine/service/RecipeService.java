package com.example.coffee_machine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.coffee_machine.dto.IngredientDto;
import com.example.coffee_machine.dto.RecipeDto;
import com.example.coffee_machine.model.Ingredient;
import com.example.coffee_machine.model.Recipe;
import com.example.coffee_machine.model.RecipeIngredient;
import com.example.coffee_machine.repository.IngredientRepository;
import com.example.coffee_machine.repository.RecipeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeService {
    
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Recipe not found: " + id));
    }


    public RecipeDto createRecipe(RecipeDto recipeDto) {
        // check if recipe exists
        if (recipeRepository.findByName(recipeDto.getName()).isPresent()) {
            throw new RuntimeException(recipeDto.getName() + "already exists.");
        }

        // create recipe
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());

        
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        for (IngredientDto ingredientDto : recipeDto.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientDto.getId())
                .orElseThrow(() -> new RuntimeException(ingredientDto.getName() + "not found."));
            
            if (ingredientDto.getQuantity() <= 0) {
                throw new RuntimeException("Insuffient number of " + ingredient.getName());
            }

            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipe(recipe);
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setQuantity(ingredientDto.getQuantity());
            
            recipeIngredients.add(recipeIngredient);
        }

        recipe.setRecipeIngredients(recipeIngredients);
        Recipe savedRecipe = recipeRepository.save(recipe);

        List<IngredientDto> ingredients = savedRecipe.getRecipeIngredients().stream()
            .map(ri -> {
                IngredientDto dto = new IngredientDto();
                dto.setId(ri.getIngredient().getId());
                dto.setQuantity(ri.getQuantity());
                return dto;
            }).collect(Collectors.toList());

        // convert to dto
        RecipeDto responseDto = new RecipeDto();
        responseDto.setName(savedRecipe.getName());
        responseDto.setIngredients(ingredients);
        
        return responseDto;
    }
}
