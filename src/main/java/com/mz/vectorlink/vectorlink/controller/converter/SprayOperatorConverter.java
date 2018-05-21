package com.mz.vectorlink.vectorlink.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.SprayOperator;

public class SprayOperatorConverter implements Converter<String, SprayOperator> {

	@Override
	public SprayOperator convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			SprayOperator sop = new SprayOperator();
			sop.setId(Long.valueOf(codigo));
			return sop;
		}
		return null;
	}

	

}
