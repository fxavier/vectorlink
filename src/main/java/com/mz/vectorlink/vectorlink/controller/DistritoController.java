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

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.service.CadastroDistritoService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDistritoException;

@Controller
@RequestMapping("/distritos")
public class DistritoController {
	
	@Autowired
	private CadastroDistritoService cadastroDistritoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(District district) {
		ModelAndView mv = new ModelAndView("distrito/CadastroDistrito");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid District district, Model model, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(district);
		}
		
		try {
			cadastroDistritoService.salvar(district);
		} catch(CadastroDistritoException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(district);
		}
		
		attributes.addFlashAttribute("mensagem","Distrito adicionado com sucesso");
		return new ModelAndView("redirect:/distritos/novo");
	}

}
