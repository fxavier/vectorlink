package com.mz.vectorlink.vectorlink.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.OperationalSiteRepository;
import com.mz.vectorlink.vectorlink.service.CadastroOperationalSiteService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroOperationalSiteException;

@Controller
@RequestMapping("/opsites")
public class OperationalSiteController {
	
	@Autowired
	private CadastroOperationalSiteService cadastroOperationalSiteService;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private OperationalSiteRepository operationalSiteRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo(OperationalSite operationalSite) {
		ModelAndView mv = new ModelAndView("opsites/CadastroOpSites");
		mv.addObject("districts", districtRepository.findAll());
		return mv;
		
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid OperationalSite operationalSite, BindingResult result,
			Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(operationalSite);
		}
		
		try {
			cadastroOperationalSiteService.salvar(operationalSite);
		} catch(CadastroOperationalSiteException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(operationalSite);
		}
		
		attributes.addFlashAttribute("mensagem", "Base operacional adicionada com sucesso");
		return new ModelAndView("redirect:/opsites/novo");
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<OperationalSite> pesquisarPorCodigoDistrito(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {}
		
		return operationalSiteRepository.findByDistrictId(codigoDistrito);
	}

}
