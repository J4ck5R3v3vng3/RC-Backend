package com.rc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.entity.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	// find by UserRatingAndCommentList Username //Falls das so bezeichnet alles ist
//	
//	public boolean findByUserRatingAndCommentListUserMailAdress(Recipe recipe);
//	
//	public Objekt findByEineObjektListeEinAttribut
	
	public Optional<Recipe> findByTitle(String title);
	
	//public List<Recipe> findByIngredientListName(String name);
	
}
