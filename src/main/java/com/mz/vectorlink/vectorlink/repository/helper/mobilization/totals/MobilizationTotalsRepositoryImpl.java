package com.mz.vectorlink.vectorlink.repository.helper.mobilization.totals;

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

import com.mz.vectorlink.vectorlink.model.MobilizationTotals;
import com.mz.vectorlink.vectorlink.model.MobilizationTotals_;
import com.mz.vectorlink.vectorlink.model.Mobilizer_;
import com.mz.vectorlink.vectorlink.model.Village_;
import com.mz.vectorlink.vectorlink.repository.filter.MobilizationTotalsFilter;

public class MobilizationTotalsRepositoryImpl implements MobilizationTotalsRepositoryQueries{

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Page<MobilizationTotals> filter(MobilizationTotalsFilter mobilizationFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<MobilizationTotals> criteria = builder.createQuery(MobilizationTotals.class);
		Root<MobilizationTotals> root = criteria.from(MobilizationTotals.class);
		
		Predicate[] predicates = createRestrictions(mobilizationFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<MobilizationTotals> query = manager.createQuery(criteria);
		addPaginationsRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, root(mobilizationFilter));
	}


	private Predicate[] createRestrictions(MobilizationTotalsFilter mobilizationFilter, CriteriaBuilder builder,
			Root<MobilizationTotals> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(mobilizationFilter.getVillageName())) {
			predicates.add(builder.like(builder.lower(
					root.get(MobilizationTotals_.village).get(Village_.name)), "%" + mobilizationFilter.getVillageName() + "%"));
		}
		
		if(mobilizationFilter.getStartDate() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(MobilizationTotals_.mobDate), mobilizationFilter.getStartDate()));
		}
		
		if(mobilizationFilter.getEndDate() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(MobilizationTotals_.mobDate), mobilizationFilter.getEndDate()));
		}
		
		if(mobilizationFilter.getMobCode() != null) {
			predicates.add(builder.equal(root.get(MobilizationTotals_.mobilizer).get(Mobilizer_.mobilizerCode), mobilizationFilter.getMobCode()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	private void addPaginationsRestrictions(TypedQuery<MobilizationTotals> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordPerPage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordPerPage);
		query.setMaxResults(totalRecordsPerPage);
		
	}


	private Long root(MobilizationTotalsFilter mobilizationFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<MobilizationTotals> root = criteria.from(MobilizationTotals.class);
		
		Predicate[] predicates = createRestrictions(mobilizationFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}
	
	
}
