package com.rc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rc.entity.Ingredient;
import com.rc.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class IngredientController {

	private final IngredientRepository ingredientRepository;
	
//	public IngredientController(IngredientRepository ingredientRepository) {
//		super();
//		this.ingredientRepository = ingredientRepository;
//	}

	// GET ALL
	@GetMapping("/zutaten")
	public List<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}
	
	// GET ONE

	
	
	// POST
	@PostMapping("/zutaten")
	public Ingredient createIngredient(@RequestBody @Valid Ingredient ingredient) {
		
		if(ingredientRepository.existsById(ingredient.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ingredient already in Database");
		}
		
		ingredientRepository.save(ingredient);
		return ingredient;
	}
		
	// PUT?
	
	// DELETE?
	
	
}
