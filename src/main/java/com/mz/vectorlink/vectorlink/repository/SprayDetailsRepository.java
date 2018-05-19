package com.mz.vectorlink.vectorlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.repository.helper.spray.details.SprayDetailsRepositoryQueries;

public interface SprayDetailsRepository extends JpaRepository<SprayDetails, Long>, SprayDetailsRepositoryQueries{

}
