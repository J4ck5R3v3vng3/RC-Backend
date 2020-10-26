package com.rc.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UnitOfMeasure {
	
	@JsonProperty(value = "gr")
	GRAMM_1, 
	
	@JsonProperty(value="ml")
	MILLILTER_1, 
	
	@JsonProperty(value="EL")
	EL_1, 
	
	@JsonProperty(value="TL")
	TL_1,
	
	@JsonProperty(value="Stk")
	STUECK_1, 
	
	@JsonProperty(value="Zehe")
	ZEHE_1, 
	
	@JsonProperty(value="Pck")
	PAECKCHEN_1
	
}
