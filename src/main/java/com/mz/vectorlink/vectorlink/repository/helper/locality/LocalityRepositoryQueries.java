package com.mz.vectorlink.vectorlink.repository.helper.locality;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.Locality;
import com.mz.vectorlink.vectorlink.repository.filter.LocalityFilter;

public interface LocalityRepositoryQueries {
	public Page<Locality> filtrar(LocalityFilter filtro, Pageable  pageable);

}
