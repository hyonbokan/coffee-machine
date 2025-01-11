package com.example.coffee_machine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.coffee_machine.dto.MostPopularDrinkDto;
import com.example.coffee_machine.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatisticsService {
    
    private final OrderRepository orderRepository;

    public List<Map<String, Object>> getOrderStatistics() {
        List<Object[]> results = orderRepository.findOrderCountsByRecipe();
        List<Map<String, Object>> statistics = new ArrayList<>();

        for (Object[] recipe : results) {
            Map<String, Object> stat = new HashMap<>();
            stat.put("recipeName", recipe[0]);
            stat.put("orderCount", recipe[1]);
            statistics.add(stat);
        }

        return statistics;
    }

    public MostPopularDrinkDto getMostPopularRecipe() {
        List<Object[]> recipes = orderRepository.findRecipesOrderedByPopularity();
        
        if (recipes.isEmpty()) {
            throw new RuntimeException("No recipe found.");
        }
        
        Object[] mostPopularRecipe = recipes.get(0);

        MostPopularDrinkDto dto = new MostPopularDrinkDto();
        dto.setName((String) mostPopularRecipe[0]);
        dto.setOrderCount(((Number) mostPopularRecipe[1]).intValue());

        return dto;
    }
}
