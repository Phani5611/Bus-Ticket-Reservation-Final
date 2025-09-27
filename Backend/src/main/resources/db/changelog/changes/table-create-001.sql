

CREATE TABLE IF NOT EXISTS users (
id UUID PRIMARY KEY,
username varchar(50) NOT NULL,
fist_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
email varchar(100) NOT NULL,
password TEXT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
created_by UUID NOT NULL,
updated_by UUID NOT NULL
);

CREATE TABLE  IF NOT EXISTS booking_details (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    boarding_code INTEGER NOT NULL,
    boarding_point VARCHAR(255) NOT NULL,
    destination_code INTEGER NOT NULL,
    destination_point VARCHAR(255) NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    amount INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by UUID NOT NULL
);

