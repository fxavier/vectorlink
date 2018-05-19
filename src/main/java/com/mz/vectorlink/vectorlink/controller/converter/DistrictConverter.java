package com.mz.vectorlink.vectorlink.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.vectorlink.vectorlink.model.District;

public class DistrictConverter implements Converter<String, District>{

	@Override
	public District convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			District district = new District();
			district.setId(Long.valueOf(codigo));
			return district;
		}
		return null;
	}

}
