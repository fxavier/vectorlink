package com.mz.vectorlink.vectorlink.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SprayTotals.class)
public abstract class SprayTotals_ {

	public static volatile SingularAttribute<SprayTotals, Long> insecticideFullReturned;
	public static volatile SingularAttribute<SprayTotals, Long> notSprayedStructures;
	public static volatile SingularAttribute<SprayTotals, Long> notSprayedWomen;
	public static volatile SingularAttribute<SprayTotals, Long> sprayedMan;
	public static volatile SingularAttribute<SprayTotals, Long> notSprayedPregnantWomen;
	public static volatile SingularAttribute<SprayTotals, Long> roomsSprayed;
	public static volatile SingularAttribute<SprayTotals, TeamLeader> teamLeader;
	public static volatile SingularAttribute<SprayTotals, LocalDate> sprayDate;
	public static volatile SingularAttribute<SprayTotals, Long> notSprayedChildren;
	public static volatile SingularAttribute<SprayTotals, SprayOperator> sprayOperator;
	public static volatile SingularAttribute<SprayTotals, String> reference;
	public static volatile SingularAttribute<SprayTotals, Long> notSprayedMen;
	public static volatile SingularAttribute<SprayTotals, Long> insecticideIssued;
	public static volatile SingularAttribute<SprayTotals, Long> sprayedWomen;
	public static volatile SingularAttribute<SprayTotals, Long> sprayedPregnantWomen;
	public static volatile SingularAttribute<SprayTotals, Long> sprayedChildren;
	public static volatile SingularAttribute<SprayTotals, Usuario> usuario;
	public static volatile SingularAttribute<SprayTotals, Long> id;
	public static volatile SingularAttribute<SprayTotals, Long> roomsFound;
	public static volatile SingularAttribute<SprayTotals, Village> village;
	public static volatile SingularAttribute<SprayTotals, Long> insecticideEmptyReturned;
	public static volatile SingularAttribute<SprayTotals, Long> sprayedStructures;

	public static final String INSECTICIDE_FULL_RETURNED = "insecticideFullReturned";
	public static final String NOT_SPRAYED_STRUCTURES = "notSprayedStructures";
	public static final String NOT_SPRAYED_WOMEN = "notSprayedWomen";
	public static final String SPRAYED_MAN = "sprayedMan";
	public static final String NOT_SPRAYED_PREGNANT_WOMEN = "notSprayedPregnantWomen";
	public static final String ROOMS_SPRAYED = "roomsSprayed";
	public static final String TEAM_LEADER = "teamLeader";
	public static final String SPRAY_DATE = "sprayDate";
	public static final String NOT_SPRAYED_CHILDREN = "notSprayedChildren";
	public static final String SPRAY_OPERATOR = "sprayOperator";
	public static final String REFERENCE = "reference";
	public static final String NOT_SPRAYED_MEN = "notSprayedMen";
	public static final String INSECTICIDE_ISSUED = "insecticideIssued";
	public static final String SPRAYED_WOMEN = "sprayedWomen";
	public static final String SPRAYED_PREGNANT_WOMEN = "sprayedPregnantWomen";
	public static final String SPRAYED_CHILDREN = "sprayedChildren";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String ROOMS_FOUND = "roomsFound";
	public static final String VILLAGE = "village";
	public static final String INSECTICIDE_EMPTY_RETURNED = "insecticideEmptyReturned";
	public static final String SPRAYED_STRUCTURES = "sprayedStructures";

}

