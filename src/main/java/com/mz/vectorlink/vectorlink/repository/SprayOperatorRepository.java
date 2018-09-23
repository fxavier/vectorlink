package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.repository.helper.roceador.SprayOperatorRepositoryQueries;

public interface SprayOperatorRepository extends JpaRepository<SprayOperator, Long>, SprayOperatorRepositoryQueries {
	public Optional<SprayOperator> findByNameIgnoreCase(String name);
	public List<SprayOperator> findByDistrictId(Long codigoDistrito);

}
