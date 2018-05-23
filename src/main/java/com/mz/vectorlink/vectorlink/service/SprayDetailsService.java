package com.mz.vectorlink.vectorlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.SprayDetailsRepository;
import com.mz.vectorlink.vectorlink.repository.SprayTotalsRepository;

@Service
public class SprayDetailsService {
	
	@Autowired
	private SprayDetailsRepository sprayDetailsRepository;
	
	@Autowired
	private  SprayTotalsRepository sprayTotalsRepository;
	
	@Transactional
	public void salvar(SprayDetails sprayDetails) {
		SprayTotals sprayTotals = sprayTotalsRepository.findBySprayDetailsReference(createReferencia(sprayDetails));
	    sprayDetails.setReference(createReferencia(sprayDetails));
		sprayDetails.setSprayTotals(sprayTotals); 
		sprayDetailsRepository.save(sprayDetails);
		
	}

	private String createReferencia(SprayDetails sprayDetails) {
		return sprayDetails.getSprayDate().toString() + sprayDetails.getVillage().getId() + sprayDetails.getSprayOperator().getId() + sprayDetails.getTeamLeader().getId();
	}

}
