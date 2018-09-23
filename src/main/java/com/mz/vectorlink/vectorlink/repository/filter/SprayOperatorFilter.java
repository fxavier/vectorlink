package com.mz.vectorlink.vectorlink.repository.filter;

import com.mz.vectorlink.vectorlink.model.District;

public class SprayOperatorFilter {
	
	private String name;
	
	private Long codigo;
	
	private District district;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	

}
