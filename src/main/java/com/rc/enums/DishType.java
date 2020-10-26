package com.rc.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DishType {

	@JsonProperty("Vorspeise")
	 VORSPEISE,
	 
	 @JsonProperty("Hauptgang")
	 HAUPTGANG,
	 
	 @JsonProperty("Beilage")
	 BEILAGE,
	 
	 @JsonProperty("Nachtisch")
	 NACHTISCH,
	 
	 @JsonProperty("Snack")
	 SNACK;

}
