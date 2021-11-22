CREATE TABLE if NOT EXISTS app_user
(
    id
    bigint,
    username
    VARCHAR
(
    50
) NOT NULL,
    password VARCHAR
(
    100
) NOT NULL,
    ROLE VARCHAR
(
    10
) NOT NULL,
    PRIMARY KEY
(
    id
),
    UNIQUE KEY username
(
    username
)
    );

CREATE TABLE if NOT EXISTS app_category
(
    id
    bigint,
    NAME
    VARCHAR
(
    100
) NOT NULL,
    parentid bigint,
    PRIMARY KEY
(
    id
),
    FOREIGN KEY
(
    parentid
) REFERENCES app_category
(
    id
)
    );

CREATE TABLE if NOT EXISTS app_product
(
    id
    bigint,
    NAME
    VARCHAR
(
    300
) NOT NULL,
    price DOUBLE NOT NULL,
    userid bigint NOT NULL,
    PRIMARY KEY
(
    id
),
    FOREIGN KEY
(
    userid
) REFERENCES app_user
(
    id
)
    );

CREATE TABLE if NOT EXISTS app_product_category
(
    productid
    bigint,
    categoryid
    bigint,
    PRIMARY
    KEY
(
    productid,
    categoryid
),
    FOREIGN KEY
(
    productid
) REFERENCES app_product
(
    id
),
    FOREIGN KEY
(
    categoryid
) REFERENCES app_category
(
    id
)
    );

CREATE SEQUENCE if NOT EXISTS hibernate_sequence START WITH 100;
