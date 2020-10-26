package com.rc.entity;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rc.enums.UnitOfMeasure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ingredient implements Comparable<Ingredient> {
	
	@Id
	@NotBlank
	private String name;
	
	private UnitOfMeasure totalUnit;
	
	private Double calPerTotalUnit;
	
	private Double carbsPerTotalUnit;
	private Double proteinsPerTotalUnit;
	private Double fatPerTotalUnit;
	
//	@JsonBackReference
//	@ManyToMany(mappedBy = "ingredientList")
//	Set<Recipe> recipeList = new TreeSet<Recipe>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "ingredient")
	private Set<RecipeToIngredientAmount> recipeToIngredientList = new TreeSet<>();

	@Override
	public String toString() {
		return "Ingredient [ingredientName=" + name + "]";
	}
	
	public int compareTo(Ingredient o) {
		return this.name.compareTo(o.name);
	}
}
