package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.repository.helper.chefeEquipa.TeamLeaderRepositoryQueries;

public interface TeamLeaderRepository extends JpaRepository<TeamLeader, Long>, TeamLeaderRepositoryQueries {
	
	public Optional<TeamLeader> findByNameIgnoreCase(String name);
	public List<TeamLeader> findByDistrictId(Long codigoDistrito);

}
