package com.mz.vectorlink.vectorlink.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DosDetail.class)
public abstract class DosDetail_ {

	public static volatile SingularAttribute<DosDetail, LocalDate> data;
	public static volatile SingularAttribute<DosDetail, String> sopPulvComDist45cmParede;
	public static volatile SingularAttribute<DosDetail, String> sopMantemVelocCorrecta;
	public static volatile SingularAttribute<DosDetail, DosTotal> dosTotal;
	public static volatile SingularAttribute<DosDetail, Locality> locality;
	public static volatile SingularAttribute<DosDetail, String> existeSubreposicao5cm;
	public static volatile SingularAttribute<DosDetail, TeamLeader> teamLeader;
	public static volatile SingularAttribute<DosDetail, SprayOperator> sprayOperator;
	public static volatile SingularAttribute<DosDetail, String> reference;
	public static volatile SingularAttribute<DosDetail, OperationalSite> operationalSite;
	public static volatile SingularAttribute<DosDetail, District> district;
	public static volatile SingularAttribute<DosDetail, String> existeVazamentoBomba;
	public static volatile SingularAttribute<DosDetail, String> todosPertencesNTiradosCobertos;
	public static volatile SingularAttribute<DosDetail, Long> id;
	public static volatile SingularAttribute<DosDetail, String> sopTemEPICompleto;
	public static volatile SingularAttribute<DosDetail, String> sopEnxaugou3vezes;
	public static volatile SingularAttribute<DosDetail, String> sopPulvComBombaComCntFluxo;
	public static volatile SingularAttribute<DosDetail, Village> village;
	public static volatile SingularAttribute<DosDetail, String> sopMixFor75;
	public static volatile SingularAttribute<DosDetail, String> todosPertencesForaCasa;

}

