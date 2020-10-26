package com.rc.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rc.entity.Recipe;
import com.rc.enums.Cuisine;
import com.rc.enums.DishType;
import com.rc.enums.Time;
import com.rc.repository.RecipeRepository;

//@SpringBootTest (classes = {Recipe.class, RecipeRepository.class})
//@ComponentScan({"com.rc.core", "com.rc.service"})
//@EntityScan({"com.rc.entity"})
//@EnableJpaRepositories(basePackages = "com.rc.repository")
//@EnableJpaRepositories
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@ContextConfiguration(classes = EntityTestConfiguration.class)
//class RecipeTest {
//
//		@Autowired(required = true)
//		private RecipeRepository recipeRepository;
//	
//		@Test
//		void createRecipeTest() {
//		
//		Recipe recipe = new Recipe();
//		recipe.setTitle("Rezept Test");
//		recipe.setTeaser("Teaser mit Wörtern");
//		recipe.setHowManyPortions(2);
//		recipe.setInstructions("Putzen, Schnippeln, Kochen.");
//		recipe.setCalPerPortion(500);
//		recipe.setCarbsPerPortion(5.9);
//		recipe.setFatPerPortion(20.6);
//		recipe.setProteinsPerPortion(41.7);
//		recipe.setCuisine(Cuisine.AFRIKANISCH);
//		recipe.setPrepTime(50);
//		recipe.setDishType(DishType.HAUPTGANG);
//		
//		recipeRepository.save(recipe);
//		
//		
//		
//	}
//
//}
