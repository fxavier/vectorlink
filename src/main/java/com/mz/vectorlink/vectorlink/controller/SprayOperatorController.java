package com.mz.vectorlink.vectorlink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.controller.page.PageWrapper;
import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.SprayOperatorRepository;
import com.mz.vectorlink.vectorlink.repository.filter.SprayOperatorFilter;
import com.mz.vectorlink.vectorlink.service.CadastroSprayOperatorService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroSOPException;

@Controller
@RequestMapping("/roceadores")
public class SprayOperatorController {
	
	@Autowired
	private SprayOperatorRepository sprayOperatorRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CadastroSprayOperatorService sopService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(SprayOperator sprayOperator) {
		ModelAndView mv = new ModelAndView("roceador/CadastroRoceador");
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView criar(@Valid SprayOperator sprayOperator, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if(result.hasErrors()) {
          return novo(sprayOperator);
		}
		
		try {
			sopService.salvar(sprayOperator);
		} catch(CadastroSOPException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(sprayOperator);
		}
		
	 attributes.addFlashAttribute("mensagem", "Roceador adicionado com sucesso");	
	 return new ModelAndView("redirect:/roceadores/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(SprayOperatorFilter filtro, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("roceador/PesquisaRoceador");
	    PageWrapper<SprayOperator> pageWrapper = new PageWrapper<>(sprayOperatorRepository.filtrar(filtro, pageable), request);
	    mv.addObject("districts", districtRepository.findAll());
	    mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable SprayOperator sprayOperator) {
		ModelAndView mv = novo(sprayOperator);
		mv.addObject(sprayOperator);
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SprayOperator> pesquisarPorCodigoDistrito(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		
		return sprayOperatorRepository.findByDistrictId(codigoDistrito);
	}

}
