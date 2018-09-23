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
import com.mz.vectorlink.vectorlink.model.Village;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.VillageRepository;
import com.mz.vectorlink.vectorlink.repository.filter.VillageFilter;
import com.mz.vectorlink.vectorlink.service.VillageService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroVillageException;

@Controller
@RequestMapping("/bairros")
public class VillageController {

	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private VillageService villageService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Village village) {
		ModelAndView mv = new ModelAndView("bairro/CadastroBairro");
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Village village, BindingResult result
			, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(village);
		}
		
		try {
			villageService.salvar(village);
		} catch(CadastroVillageException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(village);
		}
		
		attributes.addFlashAttribute("mensagem", "Bairro adicionado com sucesso");
		return new ModelAndView("redirect:/bairros/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(VillageFilter filtro, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("bairro/PesquisaBairros");
		PageWrapper<Village> pageWrapper = new PageWrapper<>(villageRepository.filtrar(filtro, pageable), request);
		mv.addObject("pagina", pageWrapper);
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Village> pesquisarPorCodigoLocalidade(
			@RequestParam(name = "localidade", defaultValue = "-1") Long codigoLocalidade){
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {}
		
		return villageRepository.findByLocalityId(codigoLocalidade);
	}
}
