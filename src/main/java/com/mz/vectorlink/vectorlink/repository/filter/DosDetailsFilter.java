package com.mz.vectorlink.vectorlink.repository.filter;

import java.time.LocalDate;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.model.Village;

public class DosDetailsFilter {
	
    private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	private District district;
	
	private OperationalSite operationalSite;
	
	private Locality locality;
	
	private Village village;
	
	private TeamLeader teamLeader;
	
	private SprayOperator sprayOperator;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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

	public TeamLeader getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(TeamLeader teamLeader) {
		this.teamLeader = teamLeader;
	}

	public SprayOperator getSprayOperator() {
		return sprayOperator;
	}

	public void setSprayOperator(SprayOperator sprayOperator) {
		this.sprayOperator = sprayOperator;
	}
	
	

}
