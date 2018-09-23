package com.mz.vectorlink.vectorlink.repository.filter;

import com.mz.vectorlink.vectorlink.model.District;

public class OperationalSiteFilter {
	
	private String name;
	
	private District district;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	
}
