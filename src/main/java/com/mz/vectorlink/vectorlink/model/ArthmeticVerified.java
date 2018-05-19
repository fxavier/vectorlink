package com.mz.vectorlink.vectorlink.model;

public enum ArthmeticVerified {
	
	YES("Sim"),
	NO("Nao");
	
	private String description;
	
	ArthmeticVerified(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

}
