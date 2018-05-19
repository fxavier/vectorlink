package com.mz.vectorlink.vectorlink.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.Locality;

public class LocalityConverter implements Converter<String, Locality> {

	@Override
	public Locality convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Locality locality = new Locality();
			locality.setId(Long.valueOf(codigo));
			return locality;
		}
		return null;
	}

}
