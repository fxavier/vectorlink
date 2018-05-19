/**
 * 
 */
package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDistritoException;

/**
 * @author langar
 *
 */
@Service
public class CadastroDistritoService {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Transactional
	public void salvar(District district) {
		Optional<District> distritoExistente = districtRepository.findByNameIgnoreCase(district.getName());
		if(distritoExistente.isPresent() && district.isNovo()) {
			throw new CadastroDistritoException("Esse distrito ja existe");
		}
		
		districtRepository.save(district);
		
	}

}
