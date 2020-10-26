package com.rc.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rc.enums.Cuisine;
import com.rc.enums.Diet;
import com.rc.enums.DishType;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recipe {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long recipeID;

	   @NotBlank
	   @Size(min = 5, max = 70)
	    private String title; 

	   @NotBlank
	   @Size(max = 250)
	    private String teaser; 

	   @NotNull
	   @Max(20)
	    private Integer howManyPortions;

	   @NotNull
	   @Size(min=25)
	   @Lob
	    private String instructions;

	    private Double calPerPortion;
	    private Double carbsPerPortion;
	    private Double fatPerPortion;
	    private Double proteinsPerPortion; 
	    
	    private Cuisine cuisine;
	    
	    @NotNull
	    private Integer prepTime;
	 
	    @JsonProperty	    
	    @NotNull
	    private DishType dishType;
	    
	    private final Timestamp creationDate = Timestamp.valueOf(LocalDateTime.now());
	    
	    @NotNull
	    private String pictureURL;
	    
	    // Der User, der das Rezept erstellt hat, darf sein Rezept auch modifizieren oder löschen -> Abfrage der Mailadresse
	    // Da nicht nur Nutzer Rezepte erstellen, sondern auch wir, darf dieses Feld leer bleiben
	    // falls wir uns dafür entscheiden, erstellen wir entsprechende PUT- und DELETE-Actions im Recipe-Controller, damit das Rezept selbst bearbeitet werden kann
	    // falls wir uns dafür entscheiden, erstellen wir entsprechende PUT- und DELETE-Actions im UserRatingAndComments-Controller, damit Nutzer ihre Kommentare/STerneratings verändern können
//	    @Email
//	    private String userMail;
	    
	    @ElementCollection(targetClass = Diet.class)
	    @CollectionTable(
	            name = ("recipe_to_diet"),
	            joinColumns = @JoinColumn(name = ("recipe_id"))
	    )
	    @Enumerated(EnumType.STRING)
	    @Column(name = ("dietTypeName"))
	    private Set<Diet> dietList = new TreeSet<Diet>();
	    	    	    
	    @OneToMany(mappedBy = "recipeMapped")
	    private Set<RecipeToIngredientAmount> recipeToIngredientAmountList = new TreeSet<>();
	    
	    @OneToMany(mappedBy = "recipe")
	    Set<UserRatingAndComment> userRatingAndCommentsList = new TreeSet<UserRatingAndComment>();
	    
		public int compareTo(Recipe o) {
			return this.recipeID.compareTo(o.recipeID);
		}
	    
	    public String toString() {
	    	return "Recipe with the ID " + recipeID
	    			+ "\nTitle: " + title
	    			+ "\nTeaser: " + teaser
	    			+ "\nHow many portions:  " + howManyPortions
	    			+ "\nInstructions: " + instructions
	    			+ "\nCalories per portion: " + calPerPortion
	    			+ "\nCarbs per portion: " + carbsPerPortion
	    			+ "\nFat per portion: " + fatPerPortion
	    			+ "\nProteins per portion: " + proteinsPerPortion
	    			+ "\nCuisine: " + cuisine
	    			+ "\nTime: " + prepTime
	    			+ "\nDish type: " + dishType
	    			+ "\nDiet: " + dietList
	    			+ "\nPictureURL" + pictureURL
	    			+ "\nCreationDate: " + creationDate;
	    }
}
