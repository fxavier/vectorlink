package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.repository.helper.distrito.DistrictRepositoryQueries;

public interface DistrictRepository extends JpaRepository<District, Long>, DistrictRepositoryQueries {
	public Optional<District> findByNameIgnoreCase(String name);

}
