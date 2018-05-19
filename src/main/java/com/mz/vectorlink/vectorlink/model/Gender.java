package com.mz.vectorlink.vectorlink.model;

public enum Gender {
	FEMALE("Feminino"),
	MALE("Masculino");
	
	private String description;

	Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

}
