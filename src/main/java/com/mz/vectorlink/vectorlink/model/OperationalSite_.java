package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OperationalSite.class)
public abstract class OperationalSite_ {

	public static volatile SingularAttribute<OperationalSite, District> district;
	public static volatile SingularAttribute<OperationalSite, String> name;
	public static volatile SingularAttribute<OperationalSite, Boolean> active;
	public static volatile SingularAttribute<OperationalSite, Long> id;
	public static volatile SingularAttribute<OperationalSite, Long> target;

	public static final String DISTRICT = "district";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String TARGET = "target";

}

