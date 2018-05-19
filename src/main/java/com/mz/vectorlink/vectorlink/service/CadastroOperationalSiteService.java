package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.repository.OperationalSiteRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroOperationalSiteException;

@Service
public class CadastroOperationalSiteService {
	
	@Autowired
	private OperationalSiteRepository  operationalSiteRepository;
	
	@Transactional
	public void salvar(OperationalSite operationalSite) {
		Optional<OperationalSite> opSiteExistente = operationalSiteRepository.findByNameIgnoreCase(operationalSite.getName());
		if(opSiteExistente.isPresent() && operationalSite.isNovo()) {
			throw new CadastroOperationalSiteException("Essa base operacional ja existe");
		}
		
		operationalSiteRepository.save(operationalSite);
	}

}
