package com.mz.vectorlink.vectorlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.repository.SprayOperatorRepository;

@Controller
@RequestMapping("/roceadores")
public class SprayOperatorController {
	
	@Autowired
	private SprayOperatorRepository sprayOperatorRepository;
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SprayOperator> pesquisarPorCodigoDistrito(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		
		return sprayOperatorRepository.findByDistrictId(codigoDistrito);
	}

}
