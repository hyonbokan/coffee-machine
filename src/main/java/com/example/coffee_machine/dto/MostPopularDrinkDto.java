package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class MostPopularDrinkDto {
    private String name;
    private int orderCount;
}
