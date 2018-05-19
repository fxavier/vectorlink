package com.mz.vectorlink.vectorlink.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MobilizationDetails.class)
public abstract class MobilizationDetails_ {

	public static volatile SingularAttribute<MobilizationDetails, Long> menSentitized;
	public static volatile SingularAttribute<MobilizationDetails, Long> womenSentitized;
	public static volatile SingularAttribute<MobilizationDetails, MobilizationStatus> mobilizationStatus;
	public static volatile SingularAttribute<MobilizationDetails, String> householderId;
	public static volatile SingularAttribute<MobilizationDetails, SprayAcceptance> sprayAcceptance;
	public static volatile SingularAttribute<MobilizationDetails, LocalDate> verificationDate;
	public static volatile SingularAttribute<MobilizationDetails, String> reference;
	public static volatile SingularAttribute<MobilizationDetails, ReasonNotSensitized> reasonNotSensitized;
	public static volatile SingularAttribute<MobilizationDetails, String> ArthmeticVerified;
	public static volatile SingularAttribute<MobilizationDetails, LocalDate> mobDate;
	public static volatile SingularAttribute<MobilizationDetails, ReasonNotAccepted> reasonNotAccepted;
	public static volatile SingularAttribute<MobilizationDetails, Long> id;
	public static volatile SingularAttribute<MobilizationDetails, String> householderName;
	public static volatile SingularAttribute<MobilizationDetails, MobilizationTotals> mobilizationTotals;
	public static volatile SingularAttribute<MobilizationDetails, String> PhysicalVerified;
	public static volatile SingularAttribute<MobilizationDetails, IecAssistant> iecAssistant;

	public static final String MEN_SENTITIZED = "menSentitized";
	public static final String WOMEN_SENTITIZED = "womenSentitized";
	public static final String MOBILIZATION_STATUS = "mobilizationStatus";
	public static final String HOUSEHOLDER_ID = "householderId";
	public static final String SPRAY_ACCEPTANCE = "sprayAcceptance";
	public static final String VERIFICATION_DATE = "verificationDate";
	public static final String REFERENCE = "reference";
	public static final String REASON_NOT_SENSITIZED = "reasonNotSensitized";
	public static final String ARTHMETIC_VERIFIED = "ArthmeticVerified";
	public static final String MOB_DATE = "mobDate";
	public static final String REASON_NOT_ACCEPTED = "reasonNotAccepted";
	public static final String ID = "id";
	public static final String HOUSEHOLDER_NAME = "householderName";
	public static final String MOBILIZATION_TOTALS = "mobilizationTotals";
	public static final String PHYSICAL_VERIFIED = "PhysicalVerified";
	public static final String IEC_ASSISTANT = "iecAssistant";

}

