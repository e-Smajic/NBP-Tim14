--liquibase formatted sql

--changeset kemal.hadziabdic:insert_test_stock_container_data
INSERT INTO stock_containers (arrival_date, container_id, created) 
VALUES (CURRENT_DATE, 21, CURRENT_TIMESTAMP);
INSERT INTO stock_containers (arrival_date, container_id, created) 
VALUES (CURRENT_DATE, 22, CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_inspection_data
INSERT INTO inspections (condition, inspection_date, inspector_name, notes, stock_container_id, created) 
SELECT 'Test Inspection Condition', CURRENT_DATE, 'Test Inspector Name', 'Test Inspection Notes', sc.id, CURRENT_TIMESTAMP from stock_containers sc where sc.container_id = 21;
INSERT INTO inspections (condition, inspection_date, inspector_name, notes, stock_container_id, created) 
SELECT 'Test Inspection Condition 2', CURRENT_DATE, 'Test Inspector Name 2', 'Test Inspection Notes 2', sc.id, CURRENT_TIMESTAMP from stock_containers sc where sc.container_id = 22;

--changeset kemal.hadziabdic:insert_test_report_data
INSERT INTO reports (comments, created_by, inspection_id, repair_completion_date, repaired_by, repaired_by_id, report_date, state, created) 
VALUES ('Test Comment', 1, 2, CURRENT_DATE, 'Test Repairer', 1, CURRENT_DATE, 1, CURRENT_TIMESTAMP);
INSERT INTO reports (comments, created_by, inspection_id, repair_completion_date, repaired_by, repaired_by_id, report_date, state, created) 
VALUES ('Test Comment 2', 2, 3, CURRENT_DATE, 'Test Repairer 2', 2, CURRENT_DATE, 2, CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_checkline_data
INSERT INTO checklines (component_id, cost, damage_id, length, location_id, material_id, quantity, remarks, repair_id, report_id, width, created) 
VALUES (21, 100.00, 61, 100.00, 21, 22, 1, 'Test Remarks', 21, 2, 100.00, CURRENT_TIMESTAMP);
INSERT INTO checklines (component_id, cost, damage_id, length, location_id, material_id, quantity, remarks, repair_id, report_id, width, created)
VALUES (22, 100.00, 62, 100.00, 22, 23, 2, 'Test Remarks 2', 22, 3, 100.00, CURRENT_TIMESTAMP);

--changeset kemal.hadziabdic:insert_test_repair_material_data
INSERT INTO repair_materials (checkline_id, cost, material_id, quantity_used, created) 
VALUES (22, 100.00, 22, 10, CURRENT_TIMESTAMP);
INSERT INTO repair_materials (checkline_id, cost, material_id, quantity_used, created) 
VALUES (23, 100.00, 23, 20, CURRENT_TIMESTAMP);