package com.mz.vectorlink.vectorlink.model;

public enum MobilizationStatus {

	SENTITIZED("Sensibilizada"),
	NOT_SENTITIZED("Nao Sensibilizada");
	
	private String description;
	
	MobilizationStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
}
