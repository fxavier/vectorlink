package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Village.class)
public abstract class Village_ {

	public static volatile SingularAttribute<Village, String> name;
	public static volatile SingularAttribute<Village, Locality> locality;
	public static volatile SingularAttribute<Village, Boolean> active;
	public static volatile SingularAttribute<Village, Long> id;
	public static volatile SingularAttribute<Village, Long> revisits;

	public static final String NAME = "name";
	public static final String LOCALITY = "locality";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String REVISITS = "revisits";

}

