/**
 * 
 */
package com.mz.vectorlink.vectorlink.repository.helper.distrito;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.model.District_;
import com.mz.vectorlink.vectorlink.repository.filter.DistrictFilter;

/**
 * @author langar
 *
 */
public class DistrictRepositoryImpl implements DistrictRepositoryQueries {

	@Autowired
	private EntityManager manager;
	

	@Override
	public Page<District> filtrar(DistrictFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<District> criteria = builder.createQuery(District.class);
		Root<District> root = criteria.from(District.class);
		
		Predicate[] predicates = createRestrictions(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<District> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}

	private Long total(DistrictFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<District> root = criteria.from(District.class);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
		
	}

	private void addPaginationRestrictions(TypedQuery<District> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordPerPage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordPerPage);
		query.setMaxResults(totalRecordsPerPage);
		
	}

	private Predicate[] createRestrictions(DistrictFilter filtro, CriteriaBuilder builder, Root<District> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(filtro.getName())) {
			predicates.add(builder.like(builder.lower(root.get(District_.name))
					, "%" + filtro.getName() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
