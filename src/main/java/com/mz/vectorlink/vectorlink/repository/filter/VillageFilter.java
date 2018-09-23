package com.mz.vectorlink.vectorlink.repository.filter;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.model.OperationalSite;

public class VillageFilter {
	
	private String name;
	private District district;
	private OperationalSite operationalSite;
	private Locality locality;
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
	public OperationalSite getOperationalSite() {
		return operationalSite;
	}
	public void setOperationalSite(OperationalSite operationalSite) {
		this.operationalSite = operationalSite;
	}
	public Locality getLocality() {
		return locality;
	}
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	
	

}
