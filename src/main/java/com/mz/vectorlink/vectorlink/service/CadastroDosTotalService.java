package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.DosTotalRepository;

@Service
public class CadastroDosTotalService {
	
	@Autowired
	private DosTotalRepository dosTotalRepository;
	
	
	@Transactional
	public void salvar(DosTotal dosTotal) {
		Optional<DosTotal> foundDosTotal = dosTotalRepository.findByReferencia(createReferencia(dosTotal));
		if(foundDosTotal.isPresent()) {
			throw new CadastroDosTotalException("Esse total ja foi cadastrado");
		}
		
		dosTotal.setReferencia(createReferencia(dosTotal));
		dosTotalRepository.save(dosTotal);
	}


	private String createReferencia(DosTotal dosTotal) {
		return dosTotal.getData().toString() + dosTotal.getDistrict().getId() 
				+ dosTotal.getOperationalSite().getId() + dosTotal.getTeamLeader().getTeamLeaderCode();
	}

}
