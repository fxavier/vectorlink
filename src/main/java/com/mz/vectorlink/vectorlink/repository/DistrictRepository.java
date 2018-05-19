package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.District;

public interface DistrictRepository extends JpaRepository<District, Long>{
	public Optional<District> findByNameIgnoreCase(String name);

}
