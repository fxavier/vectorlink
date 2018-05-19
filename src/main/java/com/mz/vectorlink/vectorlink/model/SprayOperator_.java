package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SprayOperator.class)
public abstract class SprayOperator_ {

	public static volatile SingularAttribute<SprayOperator, District> district;
	public static volatile SingularAttribute<SprayOperator, String> name;
	public static volatile SingularAttribute<SprayOperator, Boolean> active;
	public static volatile SingularAttribute<SprayOperator, Long> id;
	public static volatile SingularAttribute<SprayOperator, Long> sprayOperatorCode;

	public static final String DISTRICT = "district";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String SPRAY_OPERATOR_CODE = "sprayOperatorCode";

}

