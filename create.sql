
-- скрипт, заполняющий базу тестовыми данными

insert into nodes (name, region, street, building)
values
('Узел1', 'Санкт-Петербург', 'ул. Марата', '5a'),
('Узел2', 'Санкт-Петербург', 'ул. Стремянная', '32'),
('Узел3', 'Санкт-Петербург', 'ул. Восстания', '100');

insert into connection_units (name, node_id)
VALUES
('cu1.1', 1),
('cu1.2', 1),
('cu2.1', 2),
('cu2.2', 2),
('cu3.1', 3);

insert into points (number, connectionunit_id, opposite_point_id)
VALUES
(0, 1, null), --id 1
(1, 1, null), --id 2

(0, 2, null), --id 3
(1, 2, null), --id 4

(0, 3, null), --id 5
(1, 3, null), --id 6
(2, 3, null), --id 7
(3, 3, null), --id 8

(0, 4, null), --id 9
(1, 4, null), --id 10
(2, 4, null), --id 11
(3, 4, null), --id 12

(0, 5, null), --id 13
(1, 5, null); --id 14

update points
set opposite_point_id = 9
where id = 1;

update points
set opposite_point_id = 7
where id = 2;

update points
set opposite_point_id = 13
where id = 3;

update points
set opposite_point_id = 1
where id = 9;

update points
set opposite_point_id = 2
where id = 7;

update points
set opposite_point_id = 3
where id = 13;
