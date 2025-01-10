package com.example.coffee_machine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffee_machine.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    
    Optional<Recipe> findByName(String name);
}
