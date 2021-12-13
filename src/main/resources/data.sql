INSERT INTO day(name)
VALUES ('Monday'),
       ('Tuesday'),
       ('Wednesday'),
       ('Thursday'),
       ('Friday'),
       ('Saturday'),
       ('Sunday');

INSERT INTO classroom(number)
VALUES ('101'),
       ('102'),
       ('220'),
       ('221'),
       ('222'),
       ('305'),
       ('306'),
       ('410');

INSERT INTO groups (name)
VALUES ('KB-19'),
       ('KB-20'),
       ('ME-6'),
       ('ME-7');

INSERT INTO subject (name)
VALUES ('Cryptology'),
       ('Economy'),
       ('JavaCore'),
       ('English'),
       ('Calculus'),
       ('Digitization'),
       ('Physics'),
       ('Fitness');

INSERT INTO student(first_name, last_name, groups_id)
VALUES ('Alex', 'Smith', 1),
       ('Brandon', 'Jones', 1),
       ('Laura', 'Brown', 1),
       ('Fred', 'Davis', 2),
       ('Josh', 'Reed', 2),
       ('Lisa', 'Cook', 2),
       ('Kevin', 'Holmes', 3),
       ('Thomas', 'Clark', 3),
       ('Nancy', 'James', 3),
       ('Bill', 'Ward', 4),
       ('Ryan', 'Morris', 4),
       ('Eva', 'Miller', 4);

INSERT INTO schedule (day_id, groups_id, subject_id, classroom_id)
VALUES (1, 1, 1, 1),
       (1, 1, 3, 2),
       (2, 1, 5, 6),
       (2, 1, 6, 7),
       (3, 1, 7, 8),
       (4, 1, 4, 5),
       (4, 1, 8, 3),
       (5, 1, 3, 2),
       (1, 2, 3, 2),
       (1, 2, 1, 1),
       (2, 2, 6, 7),
       (2, 2, 5, 6),
       (3, 2, 7, 8),
       (4, 2, 8, 3),
       (4, 2, 4, 5),
       (5, 2, 1, 1),
       (1, 3, 2, 4),
       (1, 3, 5, 6),
       (2, 3, 4, 5),
       (2, 3, 2, 4),
       (3, 3, 8, 3),
       (4, 3, 6, 7),
       (4, 3, 5, 6),
       (5, 3, 2, 4),
       (1, 4, 5, 6),
       (1, 4, 2, 4),
       (2, 4, 2, 4),
       (2, 4, 4, 5),
       (3, 4, 2, 4),
       (4, 4, 5, 6),
       (4, 4, 6, 7),
       (5, 4, 8, 3);