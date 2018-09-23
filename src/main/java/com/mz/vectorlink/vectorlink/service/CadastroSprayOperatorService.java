package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.repository.SprayOperatorRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroSOPException;

@Service
public class CadastroSprayOperatorService {
	
	@Autowired
	private SprayOperatorRepository sprayOperatorRepository;
	
	
	@Transactional
	public void salvar(SprayOperator sprayOperator) {
		Optional<SprayOperator> foundSprayOperator = sprayOperatorRepository.findByNameIgnoreCase(sprayOperator.getName());
		if(foundSprayOperator.isPresent() && sprayOperator.isNovo()) {
			throw new CadastroSOPException("Esse nome ja existe na base de dados");
			
		}
		
		sprayOperatorRepository.save(sprayOperator);
	}

}
