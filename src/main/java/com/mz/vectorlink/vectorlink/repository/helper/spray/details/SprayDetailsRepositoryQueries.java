package com.mz.vectorlink.vectorlink.repository.helper.spray.details;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.repository.filter.SprayDetailsFilter;

public interface SprayDetailsRepositoryQueries {
	
	public Page<SprayDetails> filter(SprayDetailsFilter filter, Pageable pageable);

}
