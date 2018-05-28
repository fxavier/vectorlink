package com.mz.vectorlink.vectorlink.repository.filter;

import java.time.LocalDate;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.model.Village;

public class SprayTotalsFilter {
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private District district;
	
	private OperationalSite operationalSite;

	private Locality locality;
	
	private Village village;
	
	private String sopCode;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getSopCode() {
		return sopCode;
	}

	public void setSopCode(String sopCode) {
		this.sopCode = sopCode;
	}

		
	

}
