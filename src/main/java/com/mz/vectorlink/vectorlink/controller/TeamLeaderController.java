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
import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.repository.TeamLeaderRepository;
import com.mz.vectorlink.vectorlink.repository.filter.TeamLeaderFilter;
import com.mz.vectorlink.vectorlink.service.CadastroTeamLeaderService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroTeamleaderException;

@Controller
@RequestMapping("/chefe_equipas")
public class TeamLeaderController {
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CadastroTeamLeaderService teamLeaderservice;
	
	@RequestMapping("/novo")
	public ModelAndView novo(TeamLeader teamLeader) {
		ModelAndView mv = new ModelAndView("teamleader/CadastroTeamLeader");
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TeamLeader> pesquisarPorcodigoTeamLeader(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		return teamLeaderRepository.findByDistrictId(codigoDistrito);
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid TeamLeader teamLeader, Model model, BindingResult result,
			                   RedirectAttributes attributes) {
		if(result.hasErrors()) {
		return novo(teamLeader);
		}
		
		try {
			teamLeaderservice.salvar(teamLeader);
		} catch(CadastroTeamleaderException e) {
			result.rejectValue("name", e.getMessage(), e.getMessage());
			return novo(teamLeader);
		}
		
		attributes.addFlashAttribute("mensagem", "Chefe de equipa adicionado com sucesso");
		return new ModelAndView("redirect:/chefe_equipas/novo");
		
	}
	
	@GetMapping
	public ModelAndView pesquisar(TeamLeaderFilter filtro, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("teamleader/PesquisaTeamLeader");
		PageWrapper<TeamLeader> pageWrapper = new PageWrapper<>(teamLeaderRepository.filtrar(filtro, pageable), request);
		mv.addObject("districts", districtRepository.findAll());
		mv.addObject("pagina", pageWrapper);
		
		return mv;
	}

}
