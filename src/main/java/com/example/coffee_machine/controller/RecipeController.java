package com.example.coffee_machine.controller;
import com.example.coffee_machine.dto.ErrorResponseDto;
import com.example.coffee_machine.dto.RecipeDto;
import com.example.coffee_machine.service.RecipeService;
import com.example.coffee_machine.utils.CoffeeMachineAvailabilityChecker;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final CoffeeMachineAvailabilityChecker coffeeMachineAvailabilityChecker;
    
    @PostMapping("/create")
    public ResponseEntity<?> createRecipe(@RequestBody RecipeDto recipeDto) {

        if (!coffeeMachineAvailabilityChecker.isOperational()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ErrorResponseDto(
                    "The coffee machine is not operational at this time.",
                    HttpStatus.SERVICE_UNAVAILABLE.value(),
                    LocalDateTime.now()
                ));
        }

        RecipeDto newRecipe = recipeService.createRecipe(recipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRecipe);
    }
}
