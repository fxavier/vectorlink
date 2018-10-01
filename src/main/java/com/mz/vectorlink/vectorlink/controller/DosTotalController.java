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

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.service.CadastroDosTotalException;
import com.mz.vectorlink.vectorlink.service.CadastroDosTotalService;

@Controller
@RequestMapping("/dostotais")
public class DosTotalController {
	
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CadastroDosTotalService dosTotalService;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(DosTotal dosTotal) {
		ModelAndView mv = new ModelAndView("dos/CadastroTotaisDos");
		mv.addObject("districts", districtRepository.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid DosTotal dosTotal, Model model, BindingResult result,
			RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(dosTotal);
		}
		
		try {
			dosTotalService.salvar(dosTotal);
		} catch(CadastroDosTotalException e) {
			result.rejectValue("referencia", e.getMessage(), e.getMessage());
			return novo(dosTotal);
		}
		
		
		attributes.addFlashAttribute("mensagem", "Total adicionado com sucesso");
		
		return new ModelAndView("redirect:/dostotais/novo");
	}

}
