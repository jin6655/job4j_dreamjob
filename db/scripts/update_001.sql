CREATE TABLE post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      time timestamp
);
CREATE TABLE candidates (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      city TEXT,
                      time timestamp
);
CREATE TABLE users (
                            id SERIAL PRIMARY KEY,
                            name TEXT,
                            email TEXT UNIQUE,
                            password text
);
CREATE TABLE cities (
                       id SERIAL PRIMARY KEY,
                       name TEXT UNIQUE
);