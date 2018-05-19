package com.mz.vectorlink.vectorlink.model;

public enum PhysicalVerification {
	YES("SIM"),
	NO("Nao");
	
	private String description;
	
	PhysicalVerification(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

}
