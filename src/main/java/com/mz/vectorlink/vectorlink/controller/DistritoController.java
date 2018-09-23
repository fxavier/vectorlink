package com.mz.vectorlink.vectorlink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.controller.page.PageWrapper;
import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.filter.DistrictFilter;
import com.mz.vectorlink.vectorlink.service.CadastroDistritoService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDistritoException;

@Controller
@RequestMapping("/distritos")
public class DistritoController {
	
	@Autowired
	private CadastroDistritoService cadastroDistritoService;
	
	@Autowired
	private DistrictRepository districtRepository;
	
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
	
	@GetMapping
	public ModelAndView pesquisar(DistrictFilter districtFilter, BindingResult result, 
			@PageableDefault(size = 6) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("distrito/PesquisaDistritos");
		PageWrapper<District> pageWrapper = new PageWrapper<>(districtRepository.filtrar(districtFilter, pageable), request);
		mv.addObject("pagina", pageWrapper);
		
		return mv;
	}

}
