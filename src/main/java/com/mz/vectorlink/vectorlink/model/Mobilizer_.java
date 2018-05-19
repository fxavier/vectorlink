package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mobilizer.class)
public abstract class Mobilizer_ {

	public static volatile SingularAttribute<Mobilizer, Long> mobilizerCode;
	public static volatile SingularAttribute<Mobilizer, District> district;
	public static volatile SingularAttribute<Mobilizer, String> name;
	public static volatile SingularAttribute<Mobilizer, Boolean> active;
	public static volatile SingularAttribute<Mobilizer, Long> id;

	public static final String MOBILIZER_CODE = "mobilizerCode";
	public static final String DISTRICT = "district";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";

}

