package com.example.coffee_machine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coffee_machine.model.CoffeeMachineRecipe;

@Repository
public interface CoffeeMachineRecipeRepository extends JpaRepository<CoffeeMachineRecipe, Long> {

    List<CoffeeMachineRecipe> findByCoffeeMachineId(Long coffeeMachine);

    List<CoffeeMachineRecipe> findByRecipeId(Long recipeId);
}