package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{
	public Optional<Village> findByNameIgnoreCase(String name);
	

	
}
