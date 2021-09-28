USE user_database;

DROP TABLE IF EXISTS person;

CREATE TABLE person
(
    id         SERIAL,
    login varchar(100)    not null,
    password  varchar(100)    not null,
    PRIMARY KEY (id)
);