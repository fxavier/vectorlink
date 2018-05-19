package com.mz.vectorlink.vectorlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.LocalityRepository;
import com.mz.vectorlink.vectorlink.repository.OperationalSiteRepository;
import com.mz.vectorlink.vectorlink.repository.SprayOperatorRepository;
import com.mz.vectorlink.vectorlink.repository.TeamLeaderRepository;
import com.mz.vectorlink.vectorlink.repository.VillageRepository;
import com.mz.vectorlink.vectorlink.service.SprayTotalService;

@Controller
@RequestMapping("/totais_pulverizacao")
public class SprayTotalsController {
	
		
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private OperationalSiteRepository operationalSiteRepository;
	
	@Autowired
	private LocalityRepository localityRepository;
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private SprayOperatorRepository sopRepository;
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	@Autowired
	private SprayTotalService sprayTotalService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(SprayTotals sprayTotals) {
		ModelAndView mv = new ModelAndView("pulverizacao/CadastroTotaisPulverizacao");
		mv.addObject("districts", districtRepository.findAll());
		mv.addObject("operationalSites", operationalSiteRepository.findAll());
		mv.addObject("localities", localityRepository.findAll());
		mv.addObject("villages", villageRepository.findAll());
		mv.addObject("teamLeaders", teamLeaderRepository.findAll());
		mv.addObject("sops", sopRepository.findAll());
		return mv;
	}

}
