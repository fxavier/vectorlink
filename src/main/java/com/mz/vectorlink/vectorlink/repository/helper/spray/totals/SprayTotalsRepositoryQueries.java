package com.mz.vectorlink.vectorlink.repository.helper.spray.totals;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.filter.SprayTotalsFilter;
import com.mz.vectorlink.vectorlink.repository.projection.SprayTotalsSummary;

public interface SprayTotalsRepositoryQueries {
	
	public Page<SprayTotals> filter(SprayTotalsFilter filter, Pageable pageable);
//	public Page<SprayTotalsSummary> sumarizeSprayTotals(SprayTotalsFilter sprayTotalsFilter, Pageable pageable);
	public SprayTotals findBySprayDetailsReference(String reference);

	

}
