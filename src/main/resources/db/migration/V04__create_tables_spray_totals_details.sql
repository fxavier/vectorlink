CREATE TABLE spray_totals(
id BIGINT AUTO_INCREMENT,
spray_date DATE NOT NULL,
sprayed_structures BIGINT NOT NULL,
sprayed_man BIGINT NOT NULL,
sprayed_women BIGINT NOT NULL,
sprayed_pregnant_women BIGINT NOT NULL,
sprayed_children BIGINT NOT NULL,
structurs_not_sprayed BIGINT NOT NULL,
not_sprayed_men BIGINT NOT NULL,
not_sprayed_women BIGINT NOT NULL,
not_sprayed_pregnant_women BIGINT NOT NULL,
not_sprayed_children BIGINT NOT NULL,
rooms_found BIGINT NOT NULL,
rooms_sprayed BIGINT NOT NULL,
insecticide_issued BIGINT,
insecticide_full_returned BIGINT,
insecticide_empty_returned BIGINT,
reference VARCHAR(100),
village_id BIGINT NOT NULL,
sop_id BIGINT NOT NULL,
tl_id BIGINT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_total_spray_village
     FOREIGN KEY(village_id) REFERENCES village(id),
CONSTRAINT fk_total_sprat_team_leader
     FOREIGN KEY(tl_id) REFERENCES team_leader(id),     
CONSTRAINT fk_total_spray_sop
     FOREIGN KEY(sop_id) REFERENCES spray_operator(id)
);

CREATE TABLE spray_details(
id BIGINT AUTO_INCREMENT,
household_name VARCHAR(100) NOT NULL,
gender_person_interviwed VARCHAR(10),
household_id VARCHAR(30) NOT NULL,
status VARCHAR(50) NOT NULL,
sprayed_men BIGINT,
sprayed_women BIGINT,
sprayed_pregnant_women BIGINT,
sprayed_children BIGINT,
reason_not_sprayed VARCHAR(50),
not_sprayed_men BIGINT,
not_sprayed_women BIGINT,
not_sprayed_pregnant_women BIGINT,
not_sprayed_children BIGINT,
rooms_found BIGINT,
rooms_sprayed BIGINT,
reference VARCHAR(100),
spray_totals_id BIGINT(20),
PRIMARY KEY(id),
CONSTRAINT fk_spray_details_totals
   FOREIGN KEY(spray_totals_id) REFERENCES spray_totals(id)
);