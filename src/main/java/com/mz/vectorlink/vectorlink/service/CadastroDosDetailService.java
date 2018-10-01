package com.mz.vectorlink.vectorlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.DosDetail;
import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.DosDetailRepository;
import com.mz.vectorlink.vectorlink.repository.DosTotalRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDosDetalheException;

@Service
public class CadastroDosDetailService {
	
	@Autowired
	private DosDetailRepository dosDetailRepository;
	
	@Autowired
	private DosTotalRepository dosTotalRepository;
	
	@Transactional
	public void salvar(DosDetail dosDetail) {
		
		DosTotal dosTotal = new DosTotal();
		
		/*DosTotal foundDosTotal = dosTotalRepository.findByDosDetailsReferencia(criareferencia(dosDetail));
		if(foundDosTotal == null) {
			throw new CadastroDosDetalheException("Esse detalhe nao tem um total correspondente");
		}
*/		
		dosDetail.setReference(criareferencia(dosDetail));
		
		dosTotal.setId(1L);
		dosDetail.setDosTotal(dosTotal);
		
		dosDetailRepository.save(dosDetail);
	}

	private String criareferencia(DosDetail dosDetail) {
		return dosDetail.getData().toString() + dosDetail.getDistrict().getId() 
				+ dosDetail.getVillage().getId() + dosDetail.getSprayOperator().getId() ;
	}

}
