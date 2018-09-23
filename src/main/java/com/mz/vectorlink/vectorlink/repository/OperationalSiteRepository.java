package com.mz.vectorlink.vectorlink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.repository.helper.operationalsite.OperationalSiteRepositoryQueries;

@Repository
public interface OperationalSiteRepository extends JpaRepository<OperationalSite, Long>, OperationalSiteRepositoryQueries {
	public Optional<OperationalSite> findByNameIgnoreCase(String name);
	public List<OperationalSite> findByDistrictId(Long codigoDistrito);

}
