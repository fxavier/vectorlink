package com.mz.vectorlink.vectorlink.repository.helper.operationalsite;

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
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.District_;
import com.mz.vectorlink.vectorlink.model.OperationalSite;
import com.mz.vectorlink.vectorlink.model.OperationalSite_;
import com.mz.vectorlink.vectorlink.repository.filter.OperationalSiteFilter;

public class OperationalSiteRepositoryImpl implements OperationalSiteRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	

	@Override
	public Page<OperationalSite> filtrar(OperationalSiteFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();		
		CriteriaQuery<OperationalSite> criteria = builder.createQuery(OperationalSite.class);		
		Root<OperationalSite> root = criteria.from(OperationalSite.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
	    criteria.where(predicates);
	    
		TypedQuery<OperationalSite> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}



	private Long total(OperationalSiteFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();		
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<OperationalSite> root = criteria.from(OperationalSite.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}



	private void adicionarRestricoesDePaginacao(TypedQuery<OperationalSite> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordPerPage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordPerPage);
		query.setMaxResults(totalRecordsPerPage);
		
	}



	private Predicate[] criarRestricoes(OperationalSiteFilter filtro, CriteriaBuilder builder,
			Root<OperationalSite> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(filtro.getDistrict() != null) {
			predicates.add(builder.equal(root.get(OperationalSite_.district)
					.get(District_.name), filtro.getDistrict().getName()));
		}
		
		if(!StringUtils.isEmpty(filtro.getName())) {
			predicates.add(builder.like(builder.lower(root.get(OperationalSite_.name))
					, "%" + filtro.getName().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
