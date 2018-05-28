package com.mz.vectorlink.vectorlink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.controller.page.PageWrapper;
import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.SprayTotalsRepository;
import com.mz.vectorlink.vectorlink.repository.filter.SprayTotalsFilter;
import com.mz.vectorlink.vectorlink.repository.projection.SprayTotalsSummary;
import com.mz.vectorlink.vectorlink.service.SprayTotalService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroSprayTotalsException;

@Controller
@RequestMapping("/totais_pulverizacao")
public class SprayTotalsController {
	
		
	@Autowired
	private DistrictRepository districtRepository;
		
	@Autowired
	private SprayTotalService sprayTotalService;
	
	@Autowired
	private SprayTotalsRepository sprayTotalsRepository;
	
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
	
	@GetMapping
	public ModelAndView pesquisar(SprayTotalsFilter sprayTotalsFilter, BindingResult result, 
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest  httpServletRequest){
		
        ModelAndView mv = new ModelAndView("pulverizacao/PesquisaTotaisPulverizacao");
        mv.addObject("districts", districtRepository.findAll());
        
        PageWrapper<SprayTotals> paginaWrapper = new PageWrapper<>(sprayTotalsRepository.filter(sprayTotalsFilter, pageable),
        		httpServletRequest);
        
        mv.addObject("pagina", paginaWrapper);
        return mv;
	}
	
	@GetMapping(params = "resumir")
	public ModelAndView resumir(SprayTotalsFilter sprayTotalsFilter, BindingResult result, 
			@PageableDefault(size = 2) Pageable pageable, HttpServletRequest  httpServletRequest){
		
	        ModelAndView mv = new ModelAndView("pulverizacao/PesquisaTotaisPulverizacao");
	        mv.addObject("districts", districtRepository.findAll());
	        
	        PageWrapper<SprayTotals> paginaWrapper = new PageWrapper<>(sprayTotalsRepository.filter(sprayTotalsFilter, pageable),
	        		httpServletRequest);
	        
	        mv.addObject("pagina", paginaWrapper);
	        return mv;
	}
}
