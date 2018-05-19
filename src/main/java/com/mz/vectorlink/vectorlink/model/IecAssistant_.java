package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IecAssistant.class)
public abstract class IecAssistant_ {

	public static volatile SingularAttribute<IecAssistant, Long> iecAssistantCode;
	public static volatile SingularAttribute<IecAssistant, District> district;
	public static volatile SingularAttribute<IecAssistant, String> name;
	public static volatile SingularAttribute<IecAssistant, Boolean> active;
	public static volatile SingularAttribute<IecAssistant, Long> id;

	public static final String IEC_ASSISTANT_CODE = "iecAssistantCode";
	public static final String DISTRICT = "district";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";

}

