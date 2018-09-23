package com.mz.vectorlink.vectorlink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.controller.page.PageWrapper;
import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.LocalityRepository;
import com.mz.vectorlink.vectorlink.repository.filter.LocalityFilter;
import com.mz.vectorlink.vectorlink.service.CadastroLocalidadeService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroLocalidadeException;

@Controller
@RequestMapping("/localidades")
public class LocalidadeController {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CadastroLocalidadeService cadastrLocalidadeService;
	
	@Autowired
	private LocalityRepository localityRepository;
	
	@RequestMapping("/nova")
	public ModelAndView novo(Locality locality) {
		ModelAndView mv = new ModelAndView("localidade/CadastroLocalidade");
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/nova", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Locality locality, BindingResult result
			, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(locality);
		}
		
		try {
			cadastrLocalidadeService.salvar(locality);
		} catch(CadastroLocalidadeException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(locality);
		}
		
		attributes.addFlashAttribute("mensagem", "Localidade adicionada com sucesso");
		return new ModelAndView("redirect:/localidades/nova");
		
	}
	
	@GetMapping
	public ModelAndView pesquisar(LocalityFilter filtro, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("localidade/PesquisaLocalidades");
		PageWrapper<Locality> pageWrapper = new PageWrapper<>(localityRepository.filtrar(filtro, pageable), request);
		mv.addObject("pagina", pageWrapper);
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Locality> pesquisarPorCodigoOpSite(
			@RequestParam(name = "operationalSite", defaultValue = "-1") Long codigoOpSite){
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {}
		
		return localityRepository.findByOperationalSiteId(codigoOpSite);
	}
	

}
