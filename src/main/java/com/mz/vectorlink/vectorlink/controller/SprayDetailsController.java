package com.mz.vectorlink.vectorlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mz.vectorlink.vectorlink.model.Gender;
import com.mz.vectorlink.vectorlink.model.ReasonNotSprayed;
import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayStatus;
import com.mz.vectorlink.vectorlink.repository.SprayDetailsRepository;

@Controller
@RequestMapping("/detalhes_pulverizacao")
public class SprayDetailsController {
	
	@Autowired
	private SprayDetailsRepository sprayDetailsRepository;
	
		
	@RequestMapping("/novo")
	public ModelAndView novo(SprayDetails sprayDetails) {
		ModelAndView mv = new ModelAndView("pulverizacao/CadastroDetalhesPulverizacao");
		mv.addObject("genders", Gender.values());
		mv.addObject("status", SprayStatus.values());
		mv.addObject("reasonNotSprayeds", ReasonNotSprayed.values());
		return mv;
	}

}
