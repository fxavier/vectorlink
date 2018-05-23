package com.mz.vectorlink.vectorlink.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SprayDetails.class)
public abstract class SprayDetails_ {

	public static volatile SingularAttribute<SprayDetails, Long> notSprayedWomen;
	public static volatile SingularAttribute<SprayDetails, Long> sprayedMan;
	public static volatile SingularAttribute<SprayDetails, Long> notSprayedPregnantWomen;
	public static volatile SingularAttribute<SprayDetails, Long> roomsSprayed;
	public static volatile SingularAttribute<SprayDetails, TeamLeader> teamLeader;
	public static volatile SingularAttribute<SprayDetails, LocalDate> sprayDate;
	public static volatile SingularAttribute<SprayDetails, Long> notSprayedChildren;
	public static volatile SingularAttribute<SprayDetails, SprayOperator> sprayOperator;
	public static volatile SingularAttribute<SprayDetails, String> reference;
	public static volatile SingularAttribute<SprayDetails, SprayStatus> sprayStatus;
	public static volatile SingularAttribute<SprayDetails, Long> notSprayedMen;
	public static volatile SingularAttribute<SprayDetails, String> houseHoldName;
	public static volatile SingularAttribute<SprayDetails, String> houseHoldId;
	public static volatile SingularAttribute<SprayDetails, Long> sprayedWomen;
	public static volatile SingularAttribute<SprayDetails, Long> sprayedPregnantWomen;
	public static volatile SingularAttribute<SprayDetails, Long> sprayedChildren;
	public static volatile SingularAttribute<SprayDetails, SprayTotals> sprayTotals;
	public static volatile SingularAttribute<SprayDetails, Usuario> usuario;
	public static volatile SingularAttribute<SprayDetails, Long> id;
	public static volatile SingularAttribute<SprayDetails, Gender> genderInterviwedPerson;
	public static volatile SingularAttribute<SprayDetails, String> studyCode;
	public static volatile SingularAttribute<SprayDetails, Long> roomsFound;
	public static volatile SingularAttribute<SprayDetails, Village> village;
	public static volatile SingularAttribute<SprayDetails, ReasonNotSprayed> reasonNotSprayed;

	public static final String NOT_SPRAYED_WOMEN = "notSprayedWomen";
	public static final String SPRAYED_MAN = "sprayedMan";
	public static final String NOT_SPRAYED_PREGNANT_WOMEN = "notSprayedPregnantWomen";
	public static final String ROOMS_SPRAYED = "roomsSprayed";
	public static final String TEAM_LEADER = "teamLeader";
	public static final String SPRAY_DATE = "sprayDate";
	public static final String NOT_SPRAYED_CHILDREN = "notSprayedChildren";
	public static final String SPRAY_OPERATOR = "sprayOperator";
	public static final String REFERENCE = "reference";
	public static final String SPRAY_STATUS = "sprayStatus";
	public static final String NOT_SPRAYED_MEN = "notSprayedMen";
	public static final String HOUSE_HOLD_NAME = "houseHoldName";
	public static final String HOUSE_HOLD_ID = "houseHoldId";
	public static final String SPRAYED_WOMEN = "sprayedWomen";
	public static final String SPRAYED_PREGNANT_WOMEN = "sprayedPregnantWomen";
	public static final String SPRAYED_CHILDREN = "sprayedChildren";
	public static final String SPRAY_TOTALS = "sprayTotals";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String GENDER_INTERVIWED_PERSON = "genderInterviwedPerson";
	public static final String STUDY_CODE = "studyCode";
	public static final String ROOMS_FOUND = "roomsFound";
	public static final String VILLAGE = "village";
	public static final String REASON_NOT_SPRAYED = "reasonNotSprayed";

}

