package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.Village;
import com.mz.vectorlink.vectorlink.repository.helper.village.VillageRepositoryQueries;

public interface VillageRepository extends JpaRepository<Village, Long>, VillageRepositoryQueries {
	public Optional<Village> findByNameIgnoreCase(String name);
	public List<Village> findByLocalityId(Long codigoLocalidade);
	

	
}
