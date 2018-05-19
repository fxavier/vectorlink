package com.mz.vectorlink.vectorlink.controller.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.mz.vectorlink.vectorlink.model.Village;

public class VillageConverter implements Converter<String, Village> {

	@Override
	public Village convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Village village = new Village();
			village.setId(Long.valueOf(codigo));
		}
		return null;
	}

}
