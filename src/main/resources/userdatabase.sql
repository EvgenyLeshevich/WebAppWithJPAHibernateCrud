CREATE SCHEMA IF NOT EXISTS user_database;

USE user_database;

# Country
DROP TABLE IF EXISTS country;

CREATE TABLE country
(
    id           SERIAL,
    country_name varchar(100) not null,
    PRIMARY KEY (id)
);
# User account
DROP TABLE IF EXISTS user_account;

CREATE TABLE user_account
(
    id         SERIAL,
    first_name varchar(100)    not null,
    last_name  varchar(100)    not null,
    login  varchar(100)    not null,
    password  varchar(100)    not null,
    email  varchar(100)    not null,
    PRIMARY KEY (id),
    country_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (id) ON DELETE CASCADE
);
# User
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id         SERIAL,
    login varchar(100)    not null,
    password  varchar(100)    not null,
    PRIMARY KEY (id),
    user_account_id BIGINT UNSIGNED NOT NULL UNIQUE,
    FOREIGN KEY (user_account_id) REFERENCES user_account (id) ON DELETE CASCADE
);
# Role
DROP TABLE IF EXISTS role;

CREATE TABLE role
(
    id        SERIAL,
    role_name varchar(100) not null,
    PRIMARY KEY (id)
);
# User-role
CREATE TABLE user_roles
(
    user_id BIGINT UNSIGNED NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
# City
DROP TABLE IF EXISTS city;

CREATE TABLE city
(
    id         SERIAL,
    city_name  varchar(100)    not null,
    PRIMARY KEY (id),
    country_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (id) ON DELETE CASCADE
);