package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.DosDetail;

public interface DosDetailRepository extends JpaRepository<DosDetail, Long> {
 public Optional<DosDetail> findByReferencia(String referencia);
}
