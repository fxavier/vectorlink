package com.mz.vectorlink.vectorlink.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.helper.dos.totais.DosTotalRepositoryQueries;

public interface DosTotalRepository extends JpaRepository<DosTotal, Long>, DosTotalRepositoryQueries {
	public Optional<DosTotal> findByReferencia(String referencia);

}
