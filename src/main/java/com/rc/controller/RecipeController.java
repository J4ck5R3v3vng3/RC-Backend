package com.rc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rc.entity.Ingredient;
import com.rc.entity.Recipe;
import com.rc.entity.RecipeToIngredientAmount;
import com.rc.repository.IngredientRepository;
import com.rc.repository.RecipeRepository;
import com.rc.repository.RecipeToIngredientAmountRepository;
import com.rc.viewmodel.IngredientTransfer;
import com.rc.viewmodel.RecipeAndIngredientTransfer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RecipeController {
	
	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;
	private final RecipeToIngredientAmountRepository recipeToIngredientAmountRepository;
		

	// GET ALL
	@GetMapping("/rezepte")
	public List<Recipe> getAll() {
		return recipeRepository.findAll();
	}
	
	// GET ONE
	@GetMapping("/rezepte/{id}")
	public ResponseEntity<?> getRecipe(@PathVariable Long id) {
		Optional<Recipe> maybeRecipe = recipeRepository.findById(id);
		if (maybeRecipe.isPresent()) {
			Recipe recipe = maybeRecipe.get();
			return new ResponseEntity<>(recipe, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
			
	// POST
	@PostMapping(path="/rezept/erstellen")
	public @Valid ResponseEntity<?> createRecipe(@RequestBody @Valid RecipeAndIngredientTransfer transferRecipe) {
		
		Recipe recipe = transferRecipe.getRecipe();
		List<IngredientTransfer> ingredientList = transferRecipe.getIngredientTransferList();
		
		
		recipeRepository.save(recipe);
		
		Double caloriesRecipePerPortion = Double.valueOf(0);
		Double proteinRecipePerPortion = Double.valueOf(0);
		Double carbsRecipePerPortion = Double.valueOf(0);
		Double fatsRecipePerPortion = Double.valueOf(0);
		
		
		for (IngredientTransfer ingredient : ingredientList) {
			
			RecipeToIngredientAmount temp = new RecipeToIngredientAmount();
			Ingredient tempIngredient = ingredientRepository.getOne(ingredient.getIngredientName());
			
			temp.setIngredient(tempIngredient);
			temp.setAmountFactor(ingredient.getIngredientAmount());
			temp.setRecipeMapped(recipe);
			recipeToIngredientAmountRepository.save(temp);
			
			caloriesRecipePerPortion += (tempIngredient.getCalPerTotalUnit() * ingredient.getIngredientAmount()) / recipe.getHowManyPortions();
			carbsRecipePerPortion += (tempIngredient.getCarbsPerTotalUnit() * ingredient.getIngredientAmount()) / recipe.getHowManyPortions();
			fatsRecipePerPortion += (tempIngredient.getFatPerTotalUnit() * ingredient.getIngredientAmount()) / recipe.getHowManyPortions();
			proteinRecipePerPortion += (tempIngredient.getProteinsPerTotalUnit() * ingredient.getIngredientAmount()) / recipe.getHowManyPortions();
		}
		
		//Rounding to one floating number after point
		recipe.setCalPerPortion(Math.round(10.0 * caloriesRecipePerPortion)/10.0);
		recipe.setCarbsPerPortion(Math.round(10.0 * carbsRecipePerPortion)/10.0);
		recipe.setProteinsPerPortion(Math.round(10.0 * proteinRecipePerPortion)/10.0);
		recipe.setFatPerPortion(Math.round(10.0 * fatsRecipePerPortion)/10.0);
		recipeRepository.save(recipe);
		
		System.out.println( "Zutaten: " + ingredientList);
		System.out.println("Rezept: " + recipe);
		
		System.out.println("Viewmodel" + transferRecipe);
		return new ResponseEntity<>(transferRecipe , HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/rezepte2/{recipeID}+{ingredientName}+{amount}")
	public boolean createFactor(@PathVariable String ingredientName, @PathVariable Long recipeID, @PathVariable Double amount) {
		
		if (!recipeRepository.existsById(recipeID)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rezept nicht vorhanden!");
		}
		
		if (!ingredientRepository.existsById(ingredientName)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rezept nicht vorhanden!");
		}
		
		Recipe recipe = recipeRepository.getOne(recipeID);
		Ingredient ingredient = ingredientRepository.getOne(ingredientName);
		
		RecipeToIngredientAmount amountObject = new RecipeToIngredientAmount();
		
		amountObject.setAmountFactor(amount);
		amountObject.setIngredient(ingredient);
		amountObject.setRecipeMapped(recipe);
		System.out.println("vor Speichern");
		recipeToIngredientAmountRepository.saveAndFlush(amountObject);
		
		return true;
		
	}
	
	// GET ALL
		@GetMapping("/rezepte/bla")
		public List<RecipeToIngredientAmount> getAllLinks() {
			return recipeToIngredientAmountRepository.findAll();
		}
	
	

	
	
}
