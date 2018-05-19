package com.mz.vectorlink.vectorlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.MobilizationTotals;
import com.mz.vectorlink.vectorlink.repository.helper.mobilization.totals.MobilizationTotalsRepositoryQueries;

public interface MobilizationTotalsRepository extends JpaRepository<MobilizationTotals, Long>, MobilizationTotalsRepositoryQueries{

}
