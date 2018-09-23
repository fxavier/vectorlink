package com.mz.vectorlink.vectorlink.repository.helper.roceador;

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
import com.mz.vectorlink.vectorlink.model.SprayOperator;
import com.mz.vectorlink.vectorlink.model.SprayOperator_;
import com.mz.vectorlink.vectorlink.repository.filter.SprayOperatorFilter;

public class SprayOperatorRepositoryImpl implements SprayOperatorRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public Page<SprayOperator> filtrar(SprayOperatorFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<SprayOperator> criteria = builder.createQuery(SprayOperator.class);
		Root<SprayOperator> root = criteria.from(SprayOperator.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<SprayOperator> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}


	private void adicionarRestricoesPaginacao(TypedQuery<SprayOperator> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordPerPage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordPerPage);
		query.setMaxResults(totalRecordsPerPage);
		
	}


	

	private Long total(SprayOperatorFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<SprayOperator> root = criteria.from(SprayOperator.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(SprayOperatorFilter filtro, CriteriaBuilder builder, Root<SprayOperator> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(filtro.getName())) {
			predicates.add(builder.like(builder.lower(root.get(SprayOperator_.name)), "%" + filtro.getName().toLowerCase() + "%"));
		}
		
		if(filtro.getCodigo() != null) {
			predicates.add(builder.equal(root.get(SprayOperator_.sprayOperatorCode), filtro.getCodigo()));
		}
		
		if(filtro.getDistrict() != null) {
			predicates.add(builder.equal(root.get(SprayOperator_.district).get(District_.name), filtro.getDistrict().getName()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	

}
