package com.mz.vectorlink.vectorlink.controller.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.mz.vectorlink.vectorlink.model.OperationalSite;

public class OperationalSiteConverter implements Converter<String, OperationalSite> {

	@Override
	public OperationalSite convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			OperationalSite operationalSite = new OperationalSite();
			operationalSite.setId(Long.valueOf(codigo));
			return operationalSite;
		}
		return null;
	}

}
