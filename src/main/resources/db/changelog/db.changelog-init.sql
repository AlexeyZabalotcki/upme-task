-- liquibase formatted sql

-- changeset create tables:add constraints

DROP TABLE IF EXISTS furniture;
DROP SEQUENCE IF EXISTS furniture_seq;

CREATE SEQUENCE furniture_seq start 1 increment 1;

CREATE TABLE furniture (
    id BIGINT DEFAULT nextval('furniture_seq') PRIMARY KEY,
    height FLOAT
);

DROP TABLE IF EXISTS holes;
DROP SEQUENCE IF EXISTS hole_seq;

CREATE SEQUENCE hole_seq start 1 increment 1;

CREATE TABLE holes (
    id BIGINT DEFAULT nextval('hole_seq') PRIMARY KEY,
    diameter FLOAT,
    depth FLOAT,
    entry_speed FLOAT,
    exit_speed FLOAT,
    coordinates VARCHAR(255),
    furniture_detail_id BIGINT NOT NULL,
    CONSTRAINT fk_furniture_detail_id FOREIGN KEY (furniture_detail_id) REFERENCES furniture (id) ON DELETE CASCADE
);