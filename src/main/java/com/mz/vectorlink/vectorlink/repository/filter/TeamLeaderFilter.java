/**
 * 
 */
package com.mz.vectorlink.vectorlink.repository.filter;

import com.mz.vectorlink.vectorlink.model.District;

/**
 * @author langar
 *
 */
public class TeamLeaderFilter {
	
	private District district;
	
	private Long code;
	
	private String name;
	
	
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
