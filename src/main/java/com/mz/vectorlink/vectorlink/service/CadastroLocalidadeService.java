package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.repository.LocalityRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroLocalidadeException;

@Service
public class CadastroLocalidadeService {
	
	@Autowired
	private LocalityRepository localityRepository;
	
	@Transactional
	public void salvar(Locality locality) {
		Optional<Locality> localidadeExistente = localityRepository.findByNameIgnoreCase(locality.getName());
		if(localidadeExistente.isPresent() && locality.isNovo()) {
			throw new CadastroLocalidadeException("Essa localidade ja existe");
		}
		
		localityRepository.save(locality);
	}

}
