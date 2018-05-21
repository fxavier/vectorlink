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

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.service.SprayTotalService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroSprayTotalsException;

@Controller
@RequestMapping("/totais_pulverizacao")
public class SprayTotalsController {
	
		
	@Autowired
	private DistrictRepository districtRepository;
		
	@Autowired
	private SprayTotalService sprayTotalService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(SprayTotals sprayTotals) {
		ModelAndView mv = new ModelAndView("pulverizacao/CadastroTotaisPulverizacao");
		mv.addObject("districts", districtRepository.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid SprayTotals sprayTotals, BindingResult result, Model model
			, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(sprayTotals);
		}
		
		try {
			sprayTotalService.salvar(sprayTotals);
		} catch(CadastroSprayTotalsException e) {
			result.rejectValue("referencia", e.getMessage(), e.getMessage());
			return novo(sprayTotals);
		}
		
		attributes.addFlashAttribute("mensagem", "Total adicionado com sucesso!");
		return new ModelAndView("redirect:/totais_pulverizacao/novo");
	}

}
