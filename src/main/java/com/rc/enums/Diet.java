package com.rc.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Diet {
	
	@JsonProperty("Vegetarisch")
	VEGETARISCH,
	
	@JsonProperty("Vegan")
	VEGAN,
	
	@JsonProperty("Fisch")
	FISCH,
	
	@JsonProperty("Fleisch")
	FLEISCH,
	
	@JsonProperty("Glutenfrei")
	GLUTENFREI,
	
	@JsonProperty("Laktosefrei")
	LAKTOSEFREI,
	
	@JsonProperty("Low Carb")
	LOW_CARB,
	
	@JsonProperty("Low Fat")
	LOW_FAT
	
	
	
}
