package com.mz.vectorlink.vectorlink.repository.helper.operationalsite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.repository.filter.OperationalSiteFilter;

public interface OperationalSiteRepositoryQueries {
	
	public Page<OperationalSite> filtrar(OperationalSiteFilter filtro, Pageable pageable);

}
