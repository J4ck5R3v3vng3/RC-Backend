//package com.rc.service;
//
//import org.springframework.stereotype.Service;
//
//import com.rc.entity.Ingredient;
//import com.rc.enums.UnitOfMeasure;
//import com.rc.repository.IngredientRepository;
//
//@Service
//public class IngredientService {
//	
//	private final IngredientRepository ingridientRepository;
//	
//	public IngredientService(IngredientRepository ingridientRepository) {
//		this.ingridientRepository = ingridientRepository;
//	}
//	
//	public void createSomeIngredients() {
//		Ingredient mehl = new Ingredient();
//		mehl.setName("Mehl");
//		mehl.setTotalUnit(UnitOfMeasure.GRAMM_100);
//		mehl.setCalPerTotalUnit(100);
//		mehl.setCarbsPerTotalUnit(100.1);
//		mehl.setProteinsPerTotalUnit(100.2);
//		mehl.setFatPerTotalUnit(100.3);
//
//		Ingredient cornflakes = new Ingredient();
//		cornflakes.setName("Cornflakes");
//		cornflakes.setTotalUnit(UnitOfMeasure.GRAMM_100);
//		cornflakes.setCalPerTotalUnit(100);
//		cornflakes.setCarbsPerTotalUnit(100.1);
//		cornflakes.setProteinsPerTotalUnit(100.2);
//		cornflakes.setFatPerTotalUnit(100.3);
//
//		Ingredient beer = new Ingredient();
//		beer.setName("Bier");
//		beer.setTotalUnit(UnitOfMeasure.MILLILTER_100);
//		beer.setCalPerTotalUnit(100);
//		beer.setCarbsPerTotalUnit(100.1);
//		beer.setProteinsPerTotalUnit(100.2);
//		beer.setFatPerTotalUnit(100.3);
//		
//		Ingredient apfel = new Ingredient();
//		apfel.setName("Apfel");
//		apfel.setTotalUnit(UnitOfMeasure.GRAMM_100);
//		apfel.setCalPerTotalUnit(100);
//		apfel.setCarbsPerTotalUnit(100.1);
//		apfel.setProteinsPerTotalUnit(100.2);
//		apfel.setFatPerTotalUnit(100.3);
//		
//		ingridientRepository.save(apfel);
//		ingridientRepository.save(mehl);
//		ingridientRepository.save(cornflakes);
//		ingridientRepository.save(beer);
//	}
//
//}
