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
import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.OperationalSiteRepository;
import com.mz.vectorlink.vectorlink.repository.filter.OperationalSiteFilter;
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
	
	@GetMapping
	public ModelAndView pesquisar(OperationalSiteFilter filtro, BindingResult result,
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("opsites/PesquisaOpSites");
		PageWrapper<OperationalSite> pageWrapper = new PageWrapper<>(operationalSiteRepository.filtrar(filtro, pageable), request);
		mv.addObject("districts", districtRepository.findAll());
		mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<OperationalSite> pesquisarPorCodigoDistrito(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
				
		return operationalSiteRepository.findByDistrictId(codigoDistrito);
	}

}
