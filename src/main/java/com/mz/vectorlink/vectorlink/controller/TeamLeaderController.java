package com.mz.vectorlink.vectorlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.repository.TeamLeaderRepository;

@Controller
@RequestMapping("/chefe_equipas")
public class TeamLeaderController {
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TeamLeader> pesquisarPorcodigoTeamLeader(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		return teamLeaderRepository.findByDistrictId(codigoDistrito);
	}
	

}
