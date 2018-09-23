package com.mz.vectorlink.vectorlink.repository.helper.dos.totais;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.filter.DosTotalFilter;

public class DosTotalRepositoryImpl implements DosTotalRepositoryQueries {

	@Override
	public Page<DosTotal> filtrar(DosTotalFilter filtro, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
