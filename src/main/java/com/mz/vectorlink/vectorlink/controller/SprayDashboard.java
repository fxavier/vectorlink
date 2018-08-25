package com.mz.vectorlink.vectorlink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SprayDashboard {
	
	
	@GetMapping("/dashboard")
	public ModelAndView sprayDashboard() {
		ModelAndView mv = new ModelAndView("pulverizacao/SprayDashboard");
		
		return mv;
	}

 }
