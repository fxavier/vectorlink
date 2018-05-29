
CREATE TABLE mob_totals(
id BIGINT AUTO_INCREMENT,
date_mob DATE NOT NULL,
found_structures BIGINT NOT NULL,
sentitized_structures_yes BIGINT NOT NULL,
sentitized_structures_no BIGINT NOT NULL,
men_sentitized_yes BIGINT NOT NULL,
men_sentitized_no BIGINT NOT NULL,
women_sentitized_yes BIGINT NOT NULL,
women_sentitized_no BIGINT NOT NULL,
spray_accpetance_yes BIGINT NOT NULL,
spray_acceptance_no BIGINT NOT NULL,
reference VARCHAR(100),
mobilizer_id BIGINT,
village_id BIGINT(20) NOT NULL,
district_id BIGINT(20) NOT NULL,
operational_site_id BIGINT(20) NOT NULL,
locality_id BIGINT(20) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_total_mob_mobilizer
     FOREIGN KEY(mobilizer_id) REFERENCES mobilizer(id),
CONSTRAINT fk_total_mob_village
     FOREIGN KEY(village_id) REFERENCES village(id),   
CONSTRAINT fk_total_mob_district
     FOREIGN KEY(district_id) REFERENCES district(id),
CONSTRAINT fk_total_mob_opsite
     FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
CONSTRAINT fk_total_mob_locality
     FOREIGN KEY(locality_id) REFERENCES locality(id)     

);

CREATE TABLE mob_details(
id BIGINT AUTO_INCREMENT,
house_holder_name VARCHAR(100) NOT NULL,
house_holder_id VARCHAR(100) NOT NULL,
sentitized_structure VARCHAR(30),
reason_not_sentitized VARCHAR(50),
men_sentitized BIGINT,
women_sentitized BIGINT,
spray_acceptance VARCHAR(10),
reason_not_accepted VARCHAR(50),
reference VARCHAR(100),
iec_id BIGINT,
arthmetic_verified VARCHAR(10),
physical_verified VARCHAR(10),
verification_date DATE NOT NULL,
mob_totals_id BIGINT(20),
PRIMARY KEY(id),
CONSTRAINT fk_iec_mob_details 
     FOREIGN KEY(iec_id) REFERENCES iec_assistant(id),
CONSTRAINT fk_mob_details_totals 
     FOREIGN KEY(mob_totals_id) REFERENCES mob_totals(id)
);
