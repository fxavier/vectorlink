package com.mz.vectorlink.vectorlink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.repository.TeamLeaderRepository;
import com.mz.vectorlink.vectorlink.service.exception.CadastroTeamleaderException;

@Service
public class CadastroTeamLeaderService {
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	
	@Transactional
	public void salvar(TeamLeader teamLeader) {
		Optional<TeamLeader> foundTeamLeader = teamLeaderRepository.findByNameIgnoreCase(teamLeader.getName());
		if(foundTeamLeader.isPresent() && teamLeader.isNovo()) {
			throw new CadastroTeamleaderException("Esse nome ja foi cadastrado");
		}
		
		teamLeaderRepository.save(teamLeader);
	}

}
