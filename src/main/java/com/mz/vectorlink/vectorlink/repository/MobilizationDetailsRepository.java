package com.mz.vectorlink.vectorlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.MobilizationDetails;
import com.mz.vectorlink.vectorlink.repository.helper.mobilization.details.MobilizationDetailsRepositoryQueries;

public interface MobilizationDetailsRepository extends JpaRepository<MobilizationDetails, Long>, MobilizationDetailsRepositoryQueries{

}
