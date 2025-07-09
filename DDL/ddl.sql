create table customerdb.app_user
(
    password  varchar(255)                        null,
    roles     varchar(255)                        null,
    username  varchar(255)                        not null
        primary key,
    algorithm enum ('BCRYPT', 'PBKDF2', 'SCRYPT') null
);

create table customerdb.customer
(
    id         bigint auto_increment
        primary key,
    name       varchar(100)                        not null,
    email      varchar(100)                        not null,
    phone      varchar(20)                         null,
    country    varchar(50)                         null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    constraint email
        unique (email)
);

INSERT INTO customerdb.customer (id, name, email, phone, country, created_at) VALUES
(1, 'Alice Johnson', 'alice.johnson@example.com', '123-456-7890', 'US', '2025-07-01 17:44:41'),
(2, 'Bob Smith', 'bob.smith@example.com', '234-567-8901', 'US', '2025-07-01 17:44:41'),
(3, 'Carlos García', 'carlos.garcia@example.com', '345-678-9012', 'MX', '2025-07-01 17:44:41'),
(4, 'Diana Chen', 'diana.chen@example.com', '456-789-0123', 'CN', '2025-07-01 17:44:41'),
(5, 'Eva Müller', 'eva.muller@example.com', '567-890-1234', 'DE', '2025-07-01 17:44:41');
