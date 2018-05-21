package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.SprayOperator;

public interface SprayOperatorRepository extends JpaRepository<SprayOperator, Long>{
	public Optional<SprayOperator> findByNameIgnoreCase(String name);
	public List<SprayOperator> findByDistrictId(Long codigoDistrito);

}
