package com.rc.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rc.entity.UserRatingAndComment;
import com.rc.repository.RecipeRepository;
import com.rc.repository.UserRatingAndCommentRepository;
import com.rc.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserRatingAndCommentController {

	private final UserRatingAndCommentRepository userRatingAndCommentRepository;
	private final RecipeRepository recipeRepository;

	// GET ALL

	// GET ONE

	// POST
	@PostMapping("/kommentare")
	public ResponseEntity<?> createRating(@RequestBody @Valid UserRatingAndComment ratingAndComment) {
		
		 //Check, ob Rezept vorhanden // aber sinnfrei
		if (!recipeRepository.existsById(ratingAndComment.getRecipe().getRecipeID())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


		// Spezifisch: Check, ob die Mailadresse für dieses Rezept schon verwendet wurde
		if (userRatingAndCommentRepository.existsByUserMailAdressAndRecipe(ratingAndComment.getUserMailAdress(),
				ratingAndComment.getRecipe())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		// Alles ok, Kommentar wird angelegt
		userRatingAndCommentRepository.save(ratingAndComment);
		recipeRepository.save(ratingAndComment.getRecipe());
		return new ResponseEntity<>(ratingAndComment, HttpStatus.CREATED);

	}
}

// Kommentar wird erstellt

// PUT?

// DELETE?
