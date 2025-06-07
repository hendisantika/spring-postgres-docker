CREATE TABLE if NOT EXISTS GREETINGS
(
    id
    serial
    PRIMARY
    KEY,
    NAME
    VARCHAR
(
    50
) NOT NULL
    );

CREATE TABLE if NOT EXISTS user_profiles
(
    id UUID PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    birth_date DATE,
    sex INT,
    create_by UUID,
    create_date TIMESTAMP,
    update_by UUID,
    update_date TIMESTAMP
);
