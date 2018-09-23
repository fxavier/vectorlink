package com.mz.vectorlink.vectorlink.repository.helper.roceador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.repository.filter.SprayOperatorFilter;

public interface SprayOperatorRepositoryQueries {
	
	public Page<SprayOperator> filtrar(SprayOperatorFilter filtro, Pageable pageable);

}
