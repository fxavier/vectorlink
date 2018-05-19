package com.mz.vectorlink.vectorlink.repository.helper.spray.totals;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.filter.SprayTotalsFilter;

public interface SprayTotalsRepositoryQueries {
	
	public Page<SprayTotals> filter(SprayTotalsFilter sprayTotalsFilter, Pageable pageable);

}
