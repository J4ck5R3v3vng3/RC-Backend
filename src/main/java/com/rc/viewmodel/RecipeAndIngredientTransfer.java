/**
* 	Transferklasse, die dazu genutzt wird, ein Recipe-Objekt und eine Ingredient-Liste vom Frontend
* 	and Backend zu posten.
*/

package com.rc.viewmodel;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.rc.entity.Recipe;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeAndIngredientTransfer {
	
	@NotNull
	private Recipe recipe;
	
	@NotNull
	private ArrayList<IngredientTransfer> ingredientTransferList = new ArrayList<>();
	
}
