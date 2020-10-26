package com.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.entity.RecipeToIngredientAmount;

public interface RecipeToIngredientAmountRepository extends JpaRepository<RecipeToIngredientAmount, Long> {

}
