CREATE TABLE UserDetail (
    userno SERIAL  PRIMARY KEY,
    user_id UUID  NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    status CHAR(10) not null,
    phone VARCHAR(15)
);
