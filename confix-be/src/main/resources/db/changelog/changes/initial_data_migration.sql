--liquibase formatted sql

--changeset kemal.hadziabdic:insert_test_material_data
INSERT INTO materials (cost_per_unit, description, name, unit, created) 
VALUES (1,'Test Material Description','Test Material Name', 'Test Unit', CURRENT_TIMESTAMP);
INSERT INTO materials (cost_per_unit, description, name, unit, created) 
VALUES (2,'Test Material Description 2','Test Material Name 2', 'Test Unit 2', CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_component_data
INSERT INTO components (description, name, created) 
VALUES ('Test Component Description','Test Component Name', CURRENT_TIMESTAMP);
INSERT INTO components (description, name, created) 
VALUES ('Test Component Description 2','Test Component Name 2', CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_damage_data
INSERT INTO damages (code, name, created) 
VALUES ('Test Damage Code', 'Test Damage Name', CURRENT_TIMESTAMP);
INSERT INTO damages (code, name, created) 
VALUES ('Test Damage Code 2', 'Test Damage Name 2', CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_location_data
INSERT INTO locations (description, name, created) 
VALUES ('Test Location Description', 'Test Location Name', CURRENT_TIMESTAMP);
INSERT INTO locations (description, name, created) 
VALUES ('Test Location Description 2', 'Test Location Name 2', CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_repair_data
INSERT INTO repairs (code, description, labor_hours, created) 
VALUES ('Test Repair Code', 'Test Repair Description', 7, CURRENT_TIMESTAMP);
INSERT INTO repairs (code, description, labor_hours, created) 
VALUES ('Test Repair Code 2', 'Test Repair Description 2', 8, CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_container_data
INSERT INTO containers (container_number, container_size, container_type, owner, owner_id, created) 
VALUES ('007','Test Container Size', 'Test Container Type', 'Test Container Owner', 7, CURRENT_TIMESTAMP);
INSERT INTO containers (container_number, container_size, container_type, owner, owner_id, created) 
VALUES ('008','Test Container Size 2', 'Test Container Type 2', 'Test Container Owner 2', 8, CURRENT_TIMESTAMP);
