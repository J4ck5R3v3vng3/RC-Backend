package com.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rc.entity.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String>{

	public Ingredient findByName(String ingredientName);
	
}
