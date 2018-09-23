package com.mz.vectorlink.vectorlink.repository.helper.village;

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
import com.mz.vectorlink.vectorlink.model.Locality_;
import com.mz.vectorlink.vectorlink.model.OperationalSite_;
import com.mz.vectorlink.vectorlink.model.Village;
import com.mz.vectorlink.vectorlink.model.Village_;
import com.mz.vectorlink.vectorlink.repository.filter.VillageFilter;

public class VillageRepositoryImpl implements VillageRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Village> filtrar(VillageFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Village> criteria = builder.createQuery(Village.class);
		Root<Village> root = criteria.from(Village.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Village> query = manager.createQuery(criteria);
		adionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}

	private Long total(VillageFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Village> root = criteria.from(Village.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adionarRestricoesDePaginacao(TypedQuery<Village> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordPerpage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordPerpage);
		query.setMaxResults(totalRecordsPerPage);
		
	}

	private Predicate[] criarRestricoes(VillageFilter filtro, CriteriaBuilder builder, Root<Village> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(filtro.getName())) {
			predicates.add(builder.like(builder.lower(root.get(Village_.name))
					, "%" + filtro.getName().toLowerCase() + "%"));
		}
		
		if(filtro.getDistrict() != null) {
			predicates.add(builder.equal(root.get(Village_.locality)
					.get(Locality_.operationalSite).get(OperationalSite_.district)
					.get(District_.name), filtro.getDistrict().getName()));
		}
		
		if(filtro.getOperationalSite() != null) {
			predicates.add(builder.equal(root.get(Village_.locality)
					.get(Locality_.operationalSite).get(OperationalSite_.name), filtro.getOperationalSite()));
		}
		
		if(filtro.getLocality() != null) {
			predicates.add(builder.equal(root.get(Village_.locality)
					.get(Locality_.name), filtro.getLocality().getName()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
