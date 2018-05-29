package com.mz.vectorlink.vectorlink.repository.helper.spray.totals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.repository.filter.SprayTotalsFilter;
import com.mz.vectorlink.vectorlink.repository.paginacao.PaginacaoUtil;

public class SprayTotalsRepositoryImpl implements SprayTotalsRepositoryQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<SprayTotals> filter(SprayTotalsFilter filter, Pageable pageable) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(SprayTotals.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filter, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filter));
		
	}

	
	private Long total(SprayTotalsFilter filter) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(SprayTotals.class);
		adicionarFiltro(filter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}


	private void adicionarFiltro(SprayTotalsFilter filter, Criteria criteria) {
		if(filter != null) {
			if(filter.getDistrict() != null) {
				criteria.add(Restrictions.eq("district", filter.getDistrict()));
			}
			
			if(filter.getOperationalSite() != null) {
				criteria.add(Restrictions.eq("operationalSite", filter.getOperationalSite()));
			}
			
			if(filter.getLocality() != null) {
				criteria.add(Restrictions.eq("locality", filter.getLocality()));
			}
			
			if(filter.getVillage() != null) {
				criteria.add(Restrictions.eq("village", filter.getVillage()));
			}
			
			if(filter.getStartDate() != null) {
			//	LocalDate startDate = LocalDate.of(filter.getStartDate());
				criteria.add(Restrictions.ge("startDate", filter.getStartDate()));
			}
			
			if(filter.getEndDate() != null) {
				criteria.add(Restrictions.le("endDate", filter.getEndDate()));
			}
		}
		
	}
	

	@Override
	public SprayTotals findBySprayDetailsReference(String reference) {
		
		return manager.createQuery("from SprayTotals where reference =:referencia", SprayTotals.class)
				.setParameter("referencia", reference)
				.getSingleResult();
	}




	


	
}
