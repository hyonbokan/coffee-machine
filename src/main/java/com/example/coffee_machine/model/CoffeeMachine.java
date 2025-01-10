package com.example.coffee_machine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "coffee_machine")
public class CoffeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
