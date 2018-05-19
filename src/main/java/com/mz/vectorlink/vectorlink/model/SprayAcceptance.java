package com.mz.vectorlink.vectorlink.model;

public enum SprayAcceptance {
	
	YES("Sim"),
	NO("Nao");
	
	private String description;
	
	SprayAcceptance(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

}
