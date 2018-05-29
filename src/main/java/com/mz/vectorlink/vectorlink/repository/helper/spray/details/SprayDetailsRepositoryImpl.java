package com.mz.vectorlink.vectorlink.repository.helper.spray.details;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.SprayDetails;
import com.mz.vectorlink.vectorlink.model.SprayDetails_;
import com.mz.vectorlink.vectorlink.model.SprayOperator_;
import com.mz.vectorlink.vectorlink.model.SprayTotals;
import com.mz.vectorlink.vectorlink.model.Village_;
import com.mz.vectorlink.vectorlink.repository.filter.SprayDetailsFilter;
import com.mz.vectorlink.vectorlink.repository.filter.SprayTotalsFilter;
import com.mz.vectorlink.vectorlink.repository.paginacao.PaginacaoUtil;

public class SprayDetailsRepositoryImpl implements SprayDetailsRepositoryQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<SprayDetails> filter(SprayDetailsFilter filter, Pageable pageable) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(SprayDetails.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filter, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filter));
		
	}
	

	private void adicionarFiltro(SprayDetailsFilter filter, Criteria criteria) {
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
				LocalDate startDate = LocalDate.of(filter.getStartDate().getYear(), filter.getStartDate().getMonth(), filter.getStartDate().getDayOfMonth());
				criteria.add(Restrictions.ge("sprayDate", startDate));
			}
			
			if(filter.getEndDate() != null) {
				LocalDate endDate = LocalDate.of(filter.getEndDate().getYear(), filter.getEndDate().getMonth(), filter.getEndDate().getDayOfMonth());
				criteria.add(Restrictions.le("sprayDate", endDate));
			}
		}
		
	}

	private Long total(SprayDetailsFilter filter) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(SprayDetails.class);
		adicionarFiltro(filter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

}
