\c robots_and_jaegers;

DROP TABLE robots_and_jaegers;

CREATE TABLE robots_and_jaegers (
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       INTEGER,
    height     REAL,
    weight     REAL,
    status     TEXT,
    origin     TEXT,
    launch     DATE,
    kaiju_kill INTEGER
);

\include_relative populate.sql;
\include_relative queries.sql;