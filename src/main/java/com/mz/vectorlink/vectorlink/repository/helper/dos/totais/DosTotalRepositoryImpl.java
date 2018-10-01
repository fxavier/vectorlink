package com.mz.vectorlink.vectorlink.repository.helper.dos.totais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.DosTotal;
import com.mz.vectorlink.vectorlink.repository.filter.DosTotalFilter;

public class DosTotalRepositoryImpl implements DosTotalRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<DosTotal> filtrar(DosTotalFilter filtro, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DosTotal findByDosDetailsReferencia(String referencia) {
		return manager.createQuery("from DosTotal where referencia =:referencia", DosTotal.class)
				.setParameter("referencia", referencia)
				.getSingleResult();
	}

}
