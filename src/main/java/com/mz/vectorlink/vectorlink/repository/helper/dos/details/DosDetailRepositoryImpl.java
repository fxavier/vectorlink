package com.mz.vectorlink.vectorlink.repository.helper.dos.details;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.DosDetail;
import com.mz.vectorlink.vectorlink.model.DosDetail_;
import com.mz.vectorlink.vectorlink.repository.filter.DosDetailsFilter;

public class DosDetailRepositoryImpl implements DosDetailRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<DosDetail> filtrar(DosDetailsFilter filtro, Pageable pageable) {
	    CriteriaBuilder builder = manager.getCriteriaBuilder();
	    CriteriaQuery<DosDetail> criteria = builder.createQuery(DosDetail.class);
	    Root<DosDetail> root = criteria.from(DosDetail.class);
	    
	    Predicate[] predicates = criarRestricoes(filtro, builder, root);
	    criteria.where(predicates);
	    
	    TypedQuery<DosDetail> query = manager.createQuery(criteria);
	    adicionarRestricoesPaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}

	private Long total(DosDetailsFilter filtro) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		 Root<DosDetail> root = criteria.from(DosDetail.class);
		 
		 Predicate[] predicates = criarRestricoes(filtro, builder, root);
		 criteria.where(predicates);
		 
		 criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesPaginacao(TypedQuery<DosDetail> query, Pageable pageable) {
		int paginaCorrente = pageable.getPageNumber();
		int totalRegistosPorPagina = pageable.getPageSize();
		int primeiroRegistoPorPagina = paginaCorrente * totalRegistosPorPagina;
		
		query.setFirstResult(primeiroRegistoPorPagina);
		query.setMaxResults(totalRegistosPorPagina);
		
	}

	private Predicate[] criarRestricoes(DosDetailsFilter filtro, CriteriaBuilder builder, Root<DosDetail> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(filtro.getDataInicio() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(DosDetail_.data), filtro.getDataInicio()));
		}
		
		if(filtro.getDataFim() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(DosDetail_.data), filtro.getDataFim()));
		}
		
		if(filtro.getDistrict() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.district), filtro.getDistrict().getName()));
		}
		
		if(filtro.getOperationalSite() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.operationalSite), filtro.getOperationalSite().getName()));
		}
		
		if(filtro.getLocality() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.locality), filtro.getLocality().getName()));
		}
		
		if(filtro.getVillage() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.village), filtro.getVillage().getName()));
		}
		
		if(filtro.getTeamLeader() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.teamLeader), filtro.getTeamLeader().getName()));
		}
		
		if(filtro.getSprayOperator() != null) {
			predicates.add(builder.equal(root.get(DosDetail_.sprayOperator), filtro.getSprayOperator().getName()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
