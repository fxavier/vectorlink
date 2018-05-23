package com.mz.vectorlink.vectorlink.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.model.Gender;
import com.mz.vectorlink.vectorlink.model.ReasonNotSprayed;
import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayStatus;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.service.SprayDetailsService;

@Controller
@RequestMapping("/detalhes_pulverizacao")
public class SprayDetailsController {
	
		
	@Autowired
	private SprayDetailsService sprayDetailsService;
	
	@Autowired
	private DistrictRepository districtRepository;
	
		
	@RequestMapping("/novo")
	public ModelAndView novo(SprayDetails sprayDetails) {
		ModelAndView mv = new ModelAndView("pulverizacao/CadastroDetalhesPulverizacao");
		mv.addObject("genders", Gender.values());
		mv.addObject("status", SprayStatus.values());
		mv.addObject("reasonNotSprayeds", ReasonNotSprayed.values());
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid SprayDetails sprayDetails, BindingResult result,
			Model model, RedirectAttributes attributes) {
	    if(result.hasErrors()) {
	    	return novo(sprayDetails);
	    }
	    
	    
	    
	   sprayDetailsService.salvar(sprayDetails);
	    attributes.addFlashAttribute("mensagem", "Detalhe de pulverizacao adicionado com sucesso");
	    return new ModelAndView("redirect:/detalhes_pulverizacao/novo");
	}

}
