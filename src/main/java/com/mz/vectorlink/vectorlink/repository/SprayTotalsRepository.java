package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.helper.spray.totals.SprayTotalsRepositoryQueries;

public interface SprayTotalsRepository extends JpaRepository<SprayTotals, Long>, SprayTotalsRepositoryQueries{

	public Optional<SprayTotals> findByReference(String reference);
	
}
