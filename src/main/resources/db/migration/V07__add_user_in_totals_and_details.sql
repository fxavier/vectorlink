ALTER TABLE spray_totals
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_spray_totals_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);
    
ALTER TABLE spray_details
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_spray_details_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);
    
ALTER TABLE mob_details
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_mob_details_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);
    
ALTER TABLE mob_totals
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_mob_totals_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);   
    
ALTER TABLE dos_details
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_dos_details_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);
    
ALTER TABLE dos_totals
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_dos_totals_user
    FOREIGN KEY(usuario_id) REFERENCES usuario(codigo);