package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.Village;
import com.mz.vectorlink.vectorlink.repository.VillageRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroVillageException;

@Service
public class VillageService {
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Transactional
	public void salvar(Village village) {
		Optional<Village> villageExistente = villageRepository.findByNameIgnoreCase(village.getName());
		if(villageExistente.isPresent() && village.isNovo()) {
			throw new CadastroVillageException("Esse bairro ja existe");
		}
		
		villageRepository.save(village);
	}

}
