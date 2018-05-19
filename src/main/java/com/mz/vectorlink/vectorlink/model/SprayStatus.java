package com.mz.vectorlink.vectorlink.model;

public enum SprayStatus {
	
	SPRAYED("Pulverizada"),
	NOT_SPRAYED("Nao Pulverizada");
	
	private String description;
	
	SprayStatus(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	
}
