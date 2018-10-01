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

import com.mz.vectorlink.vectorlink.model.DosDetail;
import com.mz.vectorlink.vectorlink.repository.DistrictRepository;
import com.mz.vectorlink.vectorlink.service.CadastroDosDetailService;
import com.mz.vectorlink.vectorlink.service.exception.CadastroDosDetalheException;

@Controller
@RequestMapping("/dosdetalhes")
public class DosDetailController {
		
	@Autowired
	private CadastroDosDetailService service;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo(DosDetail dosDetail) {
		ModelAndView mv = new ModelAndView("dos/CadastroDetalhesDos");
	    mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid DosDetail dosDetail, Model model, BindingResult result
			, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(dosDetail);
		}
		
		try {
			service.salvar(dosDetail);
		} catch(CadastroDosDetalheException e) {
			result.rejectValue("referencia", e.getMessage(), e.getMessage());
			return novo(dosDetail);
		}
		
		attributes.addFlashAttribute("mensagem", "Detalhe adicionado com sucesso");
		
		return new ModelAndView("redirect:/dosdetalhes/novo");
	}

}
