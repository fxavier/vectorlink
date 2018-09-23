package com.mz.vectorlink.vectorlink.repository.helper.dos.totais;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.filter.DosTotalFilter;

public interface DosTotalRepositoryQueries {
	
	public Page<DosTotal> filtrar(DosTotalFilter filtro, Pageable pageable);

}
