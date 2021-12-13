CREATE DATABASE university_repository;

CREATE TABLE IF NOT EXISTS university_repository.day
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS university_repository.classroom
(
    id     SERIAL PRIMARY KEY,
    number VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS university_repository.groups
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS university_repository.subject
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS university_repository.student
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    groups_id  INT          NOT NULL REFERENCES groups (id) ON DELETE RESTRICT,
    UNIQUE (groups_id, first_name, last_name)
);

CREATE TABLE IF NOT EXISTS university_repository.schedule
(
    id           SERIAL PRIMARY KEY,
    day_id       INT NOT NULL REFERENCES day (id) ON DELETE RESTRICT,
    groups_id    INT NOT NULL REFERENCES groups (id) ON DELETE RESTRICT,
    subject_id   INT NOT NULL REFERENCES subject (id) ON DELETE RESTRICT,
    classroom_id INT NOT NULL REFERENCES classroom (id) ON DELETE RESTRICT
);



