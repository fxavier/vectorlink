package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.repository.helper.locality.LocalityRepositoryQueries;

public interface LocalityRepository extends JpaRepository<Locality, Long>, LocalityRepositoryQueries {
	public Optional<Locality> findByNameIgnoreCase(String name);
	public List<Locality> findByOperationalSiteId(Long codigoOpSite);

	

}
