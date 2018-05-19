package com.mz.vectorlink.vectorlink.repository.helper.mobilization.totals;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.MobilizationTotals;
import com.mz.vectorlink.vectorlink.repository.filter.MobilizationTotalsFilter;

public interface MobilizationTotalsRepositoryQueries {
	
	public Page<MobilizationTotals> filter(MobilizationTotalsFilter mobilizationFilter, Pageable pageable);

}
