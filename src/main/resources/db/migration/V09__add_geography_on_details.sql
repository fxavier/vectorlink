ALTER TABLE spray_details
ADD district_id BIGINT(20) NOT NULL,
ADD operational_site_id BIGINT(20) NOT NULL,
ADD locality_id BIGINT(20) NOT NULL,
ADD CONSTRAINT fk_details_spray_district
     FOREIGN KEY(district_id) REFERENCES district(id),
ADD CONSTRAINT fk_details_spray_opsite
     FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
ADD CONSTRAINT fk_details_spray_locality
     FOREIGN KEY(locality_id) REFERENCES locality(id);
     
ALTER TABLE mob_details
ADD district_id BIGINT(20) NOT NULL,
ADD operational_site_id BIGINT(20) NOT NULL,
ADD locality_id BIGINT(20) NOT NULL,
ADD CONSTRAINT fk_details_mob_district
     FOREIGN KEY(district_id) REFERENCES district(id),
ADD CONSTRAINT fk_details_mob_opsite
     FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
ADD CONSTRAINT fk_details_mob_locality
     FOREIGN KEY(locality_id) REFERENCES locality(id);
     
ALTER TABLE dos_details
ADD district_id BIGINT(20) NOT NULL,
ADD operational_site_id BIGINT(20) NOT NULL,
ADD locality_id BIGINT(20) NOT NULL,
ADD village_id BIGINT(20) NOT NULL,
ADD CONSTRAINT fk_details_dos_district
     FOREIGN KEY(district_id) REFERENCES district(id),
ADD CONSTRAINT fk_details_dos_opsite
     FOREIGN KEY(operational_site_id) REFERENCES operational_site(id),
ADD CONSTRAINT fk_details_dos_locality
     FOREIGN KEY(locality_id) REFERENCES locality(id),
ADD CONSTRAINT fk_details_dos_village
     FOREIGN KEY(village_id) REFERENCES village(id);