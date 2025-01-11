package com.example.coffee_machine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee_machine.dto.MostPopularDrinkDto;
import com.example.coffee_machine.dto.RecipeDto;
import com.example.coffee_machine.service.StatisticsService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/stats")
public class StatisticsController {

    private final StatisticsService statisticsService;
    
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getOrderStatistics() {
        return ResponseEntity.ok(statisticsService.getOrderStatistics());
    }

    @GetMapping("/most-popular")
    public ResponseEntity<MostPopularDrinkDto> getMostPopularRecipe() {
        return ResponseEntity.ok(statisticsService.getMostPopularRecipe());
    }
}
