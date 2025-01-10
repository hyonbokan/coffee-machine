package com.example.coffee_machine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffee_machine.model.RecipeIngredient;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    
    List<RecipeIngredient> findByRecipeId(Long recipeId);

    List<RecipeIngredient> findByIngredientId(Long ingredientId);
}