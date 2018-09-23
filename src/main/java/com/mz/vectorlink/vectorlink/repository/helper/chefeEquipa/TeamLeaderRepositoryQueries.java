package com.mz.vectorlink.vectorlink.repository.helper.chefeEquipa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.repository.filter.TeamLeaderFilter;

public interface TeamLeaderRepositoryQueries {

	public Page<TeamLeader> filtrar(TeamLeaderFilter filtro, Pageable pageable);
}
