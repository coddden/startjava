\c robots;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       INTEGER,
    height     REAL,
    weight     NUMERIC,
    status     TEXT,
    origin     TEXT,
    launch     DATE,
    kaiju_kill INTEGER
);

\include_relative populate.sql;
\include_relative queries.sql;