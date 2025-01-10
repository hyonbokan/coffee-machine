package com.example.coffee_machine.controller;
import com.example.coffee_machine.dto.RecipeDto;
import com.example.coffee_machine.service.RecipeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    // public RecipeController(RecipeService recipeService) {
    //     this.recipeService = recipeService;
    // }
    
    @PostMapping("/create")
    public String createRecipe(@RequestBody RecipeDto recipeDto) {
        // recipeService.createRecipe(recipeDto);
        //TODO: process POST request
        return "";
    }
}
