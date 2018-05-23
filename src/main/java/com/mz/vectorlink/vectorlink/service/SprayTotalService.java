/**
 * 
 */
package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.SprayTotalsRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroSprayTotalsException;

/**
 * @author langar
 *
 */
@Service
public class SprayTotalService {
	
	@Autowired
	private SprayTotalsRepository sprayTotalsRepository;
	
	@Transactional
	public void salvar(SprayTotals sprayTotals) {
		Optional<SprayTotals> totalExistente = sprayTotalsRepository.findByReferenceIgnoreCase(sprayTotals.getReference());
	    
		if(totalExistente.isPresent() && sprayTotals.isNovo()) {
			throw new CadastroSprayTotalsException("Esse total ja foi cadastrado");
		}
		
		if(isVariablesNotEmpty(sprayTotals)) {
			sprayTotals.setReference(createReference(sprayTotals));
		}
		
		sprayTotalsRepository.save(sprayTotals);
		
	}
	
	private boolean isVariablesNotEmpty(SprayTotals sprayTotals) {
		return sprayTotals.getSprayDate() != null && sprayTotals.getVillage().getId() != null
				    && sprayTotals.getSprayOperator().getId() != null && sprayTotals.getTeamLeader() != null;
	}

	private String createReference(SprayTotals sprayTotals) {
		return sprayTotals.getSprayDate().toString() + sprayTotals.getVillage().getId()
				   + sprayTotals.getSprayOperator().getId() + sprayTotals.getTeamLeader().getId();
	}

}
