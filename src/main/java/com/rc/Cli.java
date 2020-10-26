package com.rc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rc.entity.Ingredient;
import com.rc.entity.Recipe;
import com.rc.enums.Cuisine;
import com.rc.enums.DishType;
import com.rc.enums.UnitOfMeasure;
import com.rc.repository.IngredientRepository;
import com.rc.repository.RecipeRepository;
import com.rc.repository.UserRatingAndCommentRepository;

@Component
public class Cli implements CommandLineRunner {
	
	private final IngredientRepository ingredientRepository;
	private final RecipeRepository recipeRepository;
	private final UserRatingAndCommentRepository userRatingAndCommentRepository;
		
	public Cli(IngredientRepository ingredientRepository, RecipeRepository recipeRepository,
			UserRatingAndCommentRepository userRatingAndCommentRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
		this.userRatingAndCommentRepository = userRatingAndCommentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Console wird beim Start ausgeführt");
		
        // Zutaten für Test-DB
		var mehl = new Ingredient();
        mehl.setName("Mehl");
        mehl.setTotalUnit(UnitOfMeasure.GRAMM_1);
        mehl.setCalPerTotalUnit(3.0);
        mehl.setCarbsPerTotalUnit(4.0);
        mehl.setProteinsPerTotalUnit(5.0);
        mehl.setFatPerTotalUnit(6.0);
        ingredientRepository.save(mehl);
     
		var orange = new Ingredient();
		orange.setName("Orange");
		orange.setTotalUnit(UnitOfMeasure.STUECK_1);
		orange.setCalPerTotalUnit(3.0);
		orange.setCarbsPerTotalUnit(4.0);
		orange.setProteinsPerTotalUnit(5.0);
		orange.setFatPerTotalUnit(6.0);
        ingredientRepository.save(orange);
       
		var hefe = new Ingredient();
		hefe.setName("Hefe");
		hefe.setTotalUnit(UnitOfMeasure.STUECK_1);
		hefe.setCalPerTotalUnit(35.0);
		hefe.setCarbsPerTotalUnit(0.5);
		hefe.setProteinsPerTotalUnit(7.0);
		hefe.setFatPerTotalUnit(0.5);
        ingredientRepository.save(hefe);

        
        var koshary = new Recipe();
        koshary.setTitle("Koshary");
        koshary.setTeaser("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores ");
        koshary.setHowManyPortions(2);
        koshary.setInstructions("1. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n2. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n3. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n");
        koshary.setCalPerPortion(500.0);
        koshary.setCarbsPerPortion(50.0);
        koshary.setFatPerPortion(30.0);
        koshary.setProteinsPerPortion(25.0);
        koshary.setCuisine(Cuisine.MAROKKANISCH);
        koshary.setPrepTime(45);
        koshary.setDishType(DishType.HAUPTGANG);
        koshary.setPictureURL("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Egyptian_food_Koshary.jpg/1280px-Egyptian_food_Koshary.jpg");
                
        recipeRepository.save(koshary);

        var panDeMuerto = new Recipe();
        panDeMuerto.setTitle("Pan de Muerto");
        panDeMuerto.setTeaser("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores ");
        panDeMuerto.setHowManyPortions(2);
        panDeMuerto.setInstructions("1. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n2. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n3. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores \n\n");
        panDeMuerto.setCalPerPortion(555.0);
        panDeMuerto.setCarbsPerPortion(50.5);
        panDeMuerto.setFatPerPortion(30.5);
        panDeMuerto.setProteinsPerPortion(25.5);
        panDeMuerto.setCuisine(Cuisine.SPANISCH);
        panDeMuerto.setPrepTime(55);
        panDeMuerto.setDishType(DishType.BEILAGE);
        panDeMuerto.setPictureURL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Norma_Pati%C3%B1o_S%C3%A1nchez_A01334948_9.jpg/1280px-Norma_Pati%C3%B1o_S%C3%A1nchez_A01334948_9.jpg");
                
        recipeRepository.save(panDeMuerto);
        
        System.out.println(koshary);
				
	}
}
