package com.mz.vectorlink.vectorlink.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.TeamLeader;

public class TeamLeaderConverter implements Converter<String, TeamLeader> {

	@Override
	public TeamLeader convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			TeamLeader teamLeader = new TeamLeader();
			teamLeader.setId(Long.valueOf(codigo));
			return teamLeader;
		}
		return null;
	}

}
