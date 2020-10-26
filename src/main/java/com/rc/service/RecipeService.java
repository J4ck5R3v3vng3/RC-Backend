package com.rc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.entity.Ingredient;
import com.rc.entity.Recipe;
import com.rc.repository.IngredientRepository;
import com.rc.repository.RecipeRepository;
import com.rc.repository.UserRatingAndCommentRepository;

@Service
public class RecipeService {
	
	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;
	private final UserRatingAndCommentRepository userRatingAndCommentRepository;
//	private final DietTagRepository dietTagRepository;
//	DietTagRepository dietTagRepository

	public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository,
			UserRatingAndCommentRepository userRatingAndCommentRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.ingredientRepository = ingredientRepository;
		this.userRatingAndCommentRepository = userRatingAndCommentRepository;
//		this.dietTagRepository = dietTagRepository;
	}

//	public void deleteIngedient(Recipe recipe, Ingredient ingredient) {
//		recipe.getIngredientList().remove(ingredient);
//		recipeRepository.save(recipe);
//	}

}
