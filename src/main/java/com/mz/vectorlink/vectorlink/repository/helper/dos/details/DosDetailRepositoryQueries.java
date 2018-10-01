package com.mz.vectorlink.vectorlink.repository.helper.dos.details;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.DosDetail;
import com.mz.vectorlink.vectorlink.repository.filter.DosDetailsFilter;

public interface DosDetailRepositoryQueries {
	public Page<DosDetail> filtrar(DosDetailsFilter filtro, Pageable pageable);

}
