package com.mz.vectorlink.vectorlink.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeamLeader.class)
public abstract class TeamLeader_ {

	public static volatile SingularAttribute<TeamLeader, District> district;
	public static volatile SingularAttribute<TeamLeader, String> name;
	public static volatile SingularAttribute<TeamLeader, Boolean> active;
	public static volatile SingularAttribute<TeamLeader, Long> id;
	public static volatile SingularAttribute<TeamLeader, Long> teamLeaderCode;

	public static final String DISTRICT = "district";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String TEAM_LEADER_CODE = "teamLeaderCode";

}

