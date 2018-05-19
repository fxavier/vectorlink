package com.mz.vectorlink.vectorlink.repository.filter;

import java.time.LocalDate;

public class SprayDetailsFilter {
	
	private LocalDate startDate;
	
	private LocalDate endDate;
		
	private String houseHoldId;
		

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
	
	public String getHouseHoldId() {
		return houseHoldId;
	}

	public void setHouseHoldId(String houseHoldId) {
		this.houseHoldId = houseHoldId;
	}

	
	
	

}
