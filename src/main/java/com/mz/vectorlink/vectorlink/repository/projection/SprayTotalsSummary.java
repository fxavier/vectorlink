package com.mz.vectorlink.vectorlink.repository.projection;

import java.util.Date;

public class SprayTotalsSummary {
	
	private Long id;
	private Date sprayDate;
	private String district;
	private String opSite;
	private String locality;
	private String village;
	private Long sprayedStructures;
	private Long sprayedMan;
	private Long sprayedWomen;
	private Long sprayedPregnantWomen;
	private Long sprayedChildren;
	private Long notSprayedStructures;
	private Long notSprayedMen;
	private Long notSprayedWomen;
	private Long notSprayedPregnantWomen;
	private Long notSprayedChildren;
	private Long roomsFound;
	private Long roomsSprayed;
	private Long insecticideIssued;
	private Long insecticideFullReturned;
	private String sop;
	private String teamLeader;
	private String usuario;
	public SprayTotalsSummary(Long id, Date sprayDate, String district, String opSite, String locality, String village,
			Long sprayedStructures, Long sprayedMan, Long sprayedWomen, Long sprayedPregnantWomen, Long sprayedChildren,
			Long notSprayedStructures, Long notSprayedMen, Long notSprayedWomen, Long notSprayedPregnantWomen,
			Long notSprayedChildren, Long roomsFound, Long roomsSprayed, Long insecticideIssued,
			Long insecticideFullReturned, String sop, String teamLeader, String usuario) {
		this.id = id;
		this.sprayDate = sprayDate;
		this.district = district;
		this.opSite = opSite;
		this.locality = locality;
		this.village = village;
		this.sprayedStructures = sprayedStructures;
		this.sprayedMan = sprayedMan;
		this.sprayedWomen = sprayedWomen;
		this.sprayedPregnantWomen = sprayedPregnantWomen;
		this.sprayedChildren = sprayedChildren;
		this.notSprayedStructures = notSprayedStructures;
		this.notSprayedMen = notSprayedMen;
		this.notSprayedWomen = notSprayedWomen;
		this.notSprayedPregnantWomen = notSprayedPregnantWomen;
		this.notSprayedChildren = notSprayedChildren;
		this.roomsFound = roomsFound;
		this.roomsSprayed = roomsSprayed;
		this.insecticideIssued = insecticideIssued;
		this.insecticideFullReturned = insecticideFullReturned;
		this.sop = sop;
		this.teamLeader = teamLeader;
		this.usuario = usuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getSprayDate() {
		return sprayDate;
	}
	public void setSprayDate(Date sprayDate) {
		this.sprayDate = sprayDate;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOpSite() {
		return opSite;
	}
	public void setOpSite(String opSite) {
		this.opSite = opSite;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public Long getSprayedStructures() {
		return sprayedStructures;
	}
	public void setSprayedStructures(Long sprayedStructures) {
		this.sprayedStructures = sprayedStructures;
	}
	public Long getSprayedMan() {
		return sprayedMan;
	}
	public void setSprayedMan(Long sprayedMan) {
		this.sprayedMan = sprayedMan;
	}
	public Long getSprayedWomen() {
		return sprayedWomen;
	}
	public void setSprayedWomen(Long sprayedWomen) {
		this.sprayedWomen = sprayedWomen;
	}
	public Long getSprayedPregnantWomen() {
		return sprayedPregnantWomen;
	}
	public void setSprayedPregnantWomen(Long sprayedPregnantWomen) {
		this.sprayedPregnantWomen = sprayedPregnantWomen;
	}
	public Long getSprayedChildren() {
		return sprayedChildren;
	}
	public void setSprayedChildren(Long sprayedChildren) {
		this.sprayedChildren = sprayedChildren;
	}
	public Long getNotSprayedStructures() {
		return notSprayedStructures;
	}
	public void setNotSprayedStructures(Long notSprayedStructures) {
		this.notSprayedStructures = notSprayedStructures;
	}
	public Long getNotSprayedMen() {
		return notSprayedMen;
	}
	public void setNotSprayedMen(Long notSprayedMen) {
		this.notSprayedMen = notSprayedMen;
	}
	public Long getNotSprayedWomen() {
		return notSprayedWomen;
	}
	public void setNotSprayedWomen(Long notSprayedWomen) {
		this.notSprayedWomen = notSprayedWomen;
	}
	public Long getNotSprayedPregnantWomen() {
		return notSprayedPregnantWomen;
	}
	public void setNotSprayedPregnantWomen(Long notSprayedPregnantWomen) {
		this.notSprayedPregnantWomen = notSprayedPregnantWomen;
	}
	public Long getNotSprayedChildren() {
		return notSprayedChildren;
	}
	public void setNotSprayedChildren(Long notSprayedChildren) {
		this.notSprayedChildren = notSprayedChildren;
	}
	public Long getRoomsFound() {
		return roomsFound;
	}
	public void setRoomsFound(Long roomsFound) {
		this.roomsFound = roomsFound;
	}
	public Long getRoomsSprayed() {
		return roomsSprayed;
	}
	public void setRoomsSprayed(Long roomsSprayed) {
		this.roomsSprayed = roomsSprayed;
	}
	public Long getInsecticideIssued() {
		return insecticideIssued;
	}
	public void setInsecticideIssued(Long insecticideIssued) {
		this.insecticideIssued = insecticideIssued;
	}
	public Long getInsecticideFullReturned() {
		return insecticideFullReturned;
	}
	public void setInsecticideFullReturned(Long insecticideFullReturned) {
		this.insecticideFullReturned = insecticideFullReturned;
	}
	public String getSop() {
		return sop;
	}
	public void setSop(String sop) {
		this.sop = sop;
	}
	public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
