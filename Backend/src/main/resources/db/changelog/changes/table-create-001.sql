CREATE TABLE "bus-db".users IF NOT EXISTS(
id UUID PRIMARY KEY,
username varchar(50),
fist_name varchar(50),
last_name varchar(50),
email varchar(100),
password varchar,
created_at CURRENT_TIMESTAMP,
updated_at CURRENT_TIMESTAMP,
created_by varchar(30),
updated_by varchar(30),)

CREATE TABLE "bus-db".booking_details (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    boarding_code INTEGER,
    boarding_point VARCHAR(255),
    destination_code INTEGER,
    destination_point VARCHAR(255),
    booking_date TIMESTAMP,
    amount INTEGER
);

