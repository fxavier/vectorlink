package com.mz.vectorlink.vectorlink.repository.helper.chefeEquipa;

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
import com.mz.vectorlink.vectorlink.model.TeamLeader;
import com.mz.vectorlink.vectorlink.model.TeamLeader_;
import com.mz.vectorlink.vectorlink.repository.filter.TeamLeaderFilter;

public class TeamLeaderRepositoryImpl implements TeamLeaderRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<TeamLeader> filtrar(TeamLeaderFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TeamLeader> criteria = builder.createQuery(TeamLeader.class);
		Root<TeamLeader> root = criteria.from(TeamLeader.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<TeamLeader> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filtro));
	}

	private Long total(TeamLeaderFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<TeamLeader> root = criteria.from(TeamLeader.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesPaginacao(TypedQuery<TeamLeader> query, Pageable pageable) {
		int paginaCorrente = pageable.getPageNumber();
		int totalRegistosPorPagina = pageable.getPageSize();
		int primeiroRegistoPorPagina = paginaCorrente * totalRegistosPorPagina;
		
		query.setFirstResult(primeiroRegistoPorPagina);
		query.setMaxResults(totalRegistosPorPagina);
		
	}

	private Predicate[] criarRestricoes(TeamLeaderFilter filtro, CriteriaBuilder builder, Root<TeamLeader> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(filtro.getName())) {
			predicates.add(builder.like(builder.lower(root.get(TeamLeader_.name))
					, "%" + filtro.getName().toLowerCase() + "%"));
		}
		
		if(filtro.getCode() != null) {
			predicates.add(builder.equal(root.get(TeamLeader_.teamLeaderCode), filtro.getCode()));
		}
		
		if(filtro.getDistrict() != null) {
			predicates.add(builder.equal(root.get(TeamLeader_.district)
					.get(District_.name), filtro.getDistrict().getName()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
