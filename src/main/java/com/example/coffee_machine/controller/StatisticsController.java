package com.example.coffee_machine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee_machine.service.StatisticsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/stats")
public class StatisticsController {

    private StatisticsService statisticsService;

    // public StatisticsController(StatisticsService statisticsService) {
    //     this.statisticsService = statisticsService;
    // }
    
    @GetMapping
    public String getStats() {
        return new String();
    }

    @GetMapping("/most-popular")
    public String getMostPopularRecipe() {
        // statisticsService.findMostPopularRecipe();
        return new String();
    }
    
}
