package com.mz.vectorlink.vectorlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.DosTotalRepository;
import com.mz.vectorlink.vectorlink.repository.LocalityRepository;
import com.mz.vectorlink.vectorlink.repository.OperationalSiteRepository;
import com.mz.vectorlink.vectorlink.repository.TeamLeaderRepository;
import com.mz.vectorlink.vectorlink.repository.VillageRepository;

@Controller
@RequestMapping("/dostotais")
public class DosTotalController {
	
	@Autowired
	private DosTotalRepository dosTotalRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private OperationalSiteRepository operationalSiteRepository;
	
	@Autowired
	private LocalityRepository localityRepository;
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo(DosTotal dosTotal) {
		ModelAndView mv = new ModelAndView("dos/CadastroTotaisDos");
		mv.addObject("districts", districtRepository.findAll());
		
		return mv;
	}

}
