 CREATE TABLE dos_totals (
    id BIGSERIAL,
    data DATE NOT NULL,
    SOPMixFor75Sim BIGINT NOT NULL,
    SOPMixFor75Nao BIGINT NOT NULL,
    SOPEnxaugou3vezesSim BIGINT NOT NULL,
    SOPEnxaugou3vezesNao BIGINT NOT NULL,
    SOPTemEPICompletoSim BIGINT NOT NULL,
    SOPTemEPICompletoNao BIGINT NOT NULL,
    SOPPulvComBombaComCntFluxoSim BIGINT NOT NULL,
    SOPPulvComBombaComCntFluxoNao BIGINT NOT NULL,
    todosPertencesForaCasaSim BIGINT NOT NULL,
    todosPertencesForaCasaNao BIGINT NOT NULL,
    todosPertencesNTiradosCobertosSim BIGINT NOT NULL,
    todosPertencesNTiradosCobertosNao BIGINT NOT NULL,
    existeVazamentoBombaSim BIGINT NOT NULL,
    existeVazamentoBombaNao BIGINT NOT NULL,
    SOPPulvComDist45cmParedeSim BIGINT NOT NULL,
    SOPPulvComDist45cmParedeNao BIGINT NOT NULL,
    SOPMantemVelocCorrectaSim BIGINT NOT NULL,
    SOPMantemVelocCorrectaNao BIGINT NOT NULL,
    existeSubreposicao5cmSim BIGINT NOT NULL,
    existeSubreposicao5cmNao BIGINT NOT NULL,
    referencia VARCHAR(50) NOT NULL,
    tl_id BIGINT NOT NULL,
    village_id BIGINT NOT NULL,
    district_id BIGINT NOT NULL,
    operational_site_id BIGINT NOT NULL,
    locality_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_dos_totals_tl
       FOREIGN KEY(tl_id) REFERENCES team_leader(id),
    CONSTRAINT fk_dos_totals_village
       FOREIGN KEY(village_id) REFERENCES village(id),
    CONSTRAINT fk_dostotals_district
       FOREIGN KEY(district_id) REFERENCES district(id),
    CONSTRAINT fk_dostotals_opsite
       FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
    CONSTRAINT fk_dostotals_locality
       FOREIGN KEY(locality_id) REFERENCES locality(id)     
   );
   
   CREATE TABLE dos_details (
    id BIGSERIAL,
    data DATE NOT NULL,
    SOPMixFor75 VARCHAR(20) NOT NULL,
    SOPEnxaugou3vezes VARCHAR(20) NOT NULL,
    SOPTemEPICompleto VARCHAR(20) NOT NULL,
    SOPPulvComBombaComCntFluxo VARCHAR(20) NOT NULL,
    todosPertencesForaCasa VARCHAR(20) NOT NULL,
    todosPertencesNTiradosCobertos VARCHAR(20) NOT NULL,
    existeVazamentoBomba VARCHAR(20) NOT NULL,
    SOPPulvComDist45cmParede VARCHAR(20) NOT NULL,
    SOPMantemVelocCorrecta VARCHAR(20) NOT NULL,
    existeSubreposicao5cm VARCHAR(20),
    referencia VARCHAR(50) NOT NULL,
    tl_id BIGINT NOT NULL,
    dos_totals_id BIGINT NOT NULL,
    village_id BIGINT NOT NULL,
    district_id BIGINT NOT NULL,
    operational_site_id BIGINT NOT NULL,
    locality_id BIGINT NOT NULL,
    spray_operator_id BIGINT NOT NULL,
    PRIMARY KEY(id),    
    CONSTRAINT fk_dos_totals_tl
       FOREIGN KEY(tl_id) REFERENCES team_leader(id),
    CONSTRAINT fk_dos_details_totals
       FOREIGN KEY(dos_totals_id) REFERENCES dos_totals(id),
    CONSTRAINT fk_dos_details_village
       FOREIGN KEY(village_id) REFERENCES village(id),   
    CONSTRAINT fk_dos_details_district
       FOREIGN KEY(district_id) REFERENCES district(id),    
    CONSTRAINT fk_dos_details_opsite
       FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
    CONSTRAINT fk_dos_details_locality
       FOREIGN KEY(locality_id) REFERENCES locality(id),    
    CONSTRAINT fk_dos_details_sop
       FOREIGN KEY(spray_operator_id) REFERENCES spray_operator(id)    
);

