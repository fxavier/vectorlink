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
import com.mz.vectorlink.vectorlink.model.Gender;
import com.mz.vectorlink.vectorlink.model.ReasonNotSprayed;
import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayStatus;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;import com.mz.vectorlink.vectorlink.repository.SprayDetailsRepository;
import com.mz.vectorlink.vectorlink.repository.filter.SprayDetailsFilter;
import com.mz.vectorlink.vectorlink.service.SprayDetailsService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDetalheException;

@Controller
@RequestMapping("/detalhes_pulverizacao")
public class SprayDetailsController {
	
		
	@Autowired
	private SprayDetailsService sprayDetailsService;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private SprayDetailsRepository sprayDetailsRepository;
	
		
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
	    
	    try {
	    	
	    	sprayDetailsService.salvar(sprayDetails);
	    } catch(CadastroDetalheException e) {
	    	result.rejectValue("referencia", e.getMessage(), e.getMessage());
	    	return novo(sprayDetails);
	    }
	    
	    attributes.addFlashAttribute("mensagem", "Detalhe de pulverizacao adicionado com sucesso");
	    return new ModelAndView("redirect:/detalhes_pulverizacao/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(SprayDetailsFilter sprayDetailsFilter, BindingResult result,
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("pulverizacao/PesquisaDetalhesPulverizacao");
		mv.addObject("districts", districtRepository.findAll());
		
		PageWrapper<SprayDetails> paginaWrapper = new PageWrapper<>(sprayDetailsRepository.filter(sprayDetailsFilter, pageable), 
				httpServletRequest);
		
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	/*@GetMapping(params = "download")
	public String download(Model model) {
		model.addAttribute("details", sprayDetailsService.findAllSprayDetails());
		return"";
	}*/

}
