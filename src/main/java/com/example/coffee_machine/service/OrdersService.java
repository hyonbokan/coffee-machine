package com.example.coffee_machine.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.coffee_machine.model.Order;
import com.example.coffee_machine.model.Recipe;
import com.example.coffee_machine.repository.IngredientRepository;
import com.example.coffee_machine.repository.OrderRepository;
import com.example.coffee_machine.repository.RecipeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrdersService {
    
    private final OrderRepository orderRepository;
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    

    public createOrder(Long recipeId) {
        // get recipe
        Recipe recipe = recipeService.getRecipeById(recipeId);

        // check and update ingredients
        ingredientService.checkAndUpdateStock(recipe);

        // save
        Order order = new Order();
        order.setRecipe(recipe);
        order.setOrderDate(LocalDateTime.now());
        
        return orderRepository.save(order);
    }
}
