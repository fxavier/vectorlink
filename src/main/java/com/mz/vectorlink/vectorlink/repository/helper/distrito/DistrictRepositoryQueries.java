/**
 * 
 */
package com.mz.vectorlink.vectorlink.repository.helper.distrito;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.vectorlink.vectorlink.model.District;
import com.mz.vectorlink.vectorlink.repository.filter.DistrictFilter;


/**
 * @author 
 *
 */
public interface DistrictRepositoryQueries {
	public Page<District> filtrar(DistrictFilter filtro, Pageable pageable);

}
