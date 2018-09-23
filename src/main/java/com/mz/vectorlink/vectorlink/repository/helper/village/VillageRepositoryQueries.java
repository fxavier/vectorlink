package com.mz.vectorlink.vectorlink.repository.helper.village;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.Village;
import com.mz.vectorlink.vectorlink.repository.filter.VillageFilter;

public interface VillageRepositoryQueries {
	
	public Page<Village> filtrar(VillageFilter filtro, Pageable pageable);

}
