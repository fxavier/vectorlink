package com.mz.vectorlink.vectorlink.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.SprayDetailsRepository;
import com.mz.vectorlink.vectorlink.repository.SprayTotalsRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDetalheException;
import com.mz.vectorlink.vectorlink.utils.Utils;

@Service
public class SprayDetailsService {
	
	private final String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String candidateNum = "0123456789";

	
	@Autowired
	private SprayDetailsRepository sprayDetailsRepository;
	
	@Autowired
	private  SprayTotalsRepository sprayTotalsRepository;
	
	@Autowired
	private Utils util;
	
	@Transactional
	public void salvar(SprayDetails sprayDetails) {
		SprayTotals sprayTotals = sprayTotalsRepository.findBySprayDetailsReference(createReferencia(sprayDetails));
		if(sprayTotals == null) {
			throw new CadastroDetalheException("Esse detalhe nao tem um total correspondente, por favor verifique!");
		}
	    sprayDetails.setReference(createReferencia(sprayDetails));
		sprayDetails.setSprayTotals(sprayTotals); 
		sprayDetailsRepository.save(sprayDetails);
		
	}
	
	public List<SprayDetails> findAllSprayDetails(){
		return IntStream.rangeClosed(1, 20)
                .mapToObj(i ->  new SprayDetails())
               /* new SprayDetails(util.generateRandomChars(candidateChars, 10), util.generateRandomChars
                        (candidateChars, 10), util.generateRandomInteger(i),
                        util.generateRandomChars(candidateChars, 15), util.generateRandomChars(candidateChars,
                        15), util.generateRandomChars(candidateChars, 20),
                        util.generateRandomChars(candidateChars, 10), util.generateRandomChars(candidateChars,
                        10), util.generateRandomChars(candidateNum, 10)))*/
                .collect(Collectors.toList());
	}

	private String createReferencia(SprayDetails sprayDetails) {
		return sprayDetails.getSprayDate().toString() + sprayDetails.getVillage().getId() + sprayDetails.getSprayOperator().getId() + sprayDetails.getTeamLeader().getId();
	}

}
