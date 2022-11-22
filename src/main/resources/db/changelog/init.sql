CREATE TABLE if not exists customer
(
    customer_id bigserial PRIMARY KEY,
    name        varchar(20) NOT NULL,
    surname     varchar(20) NOT NULL,
    email       varchar(20) NOT NULL,
    phone       varchar(20) NOT NULL,
    address     varchar(50) NOT NULL,
    login       varchar(20) NOT NULL,
    password    varchar(20) NOT NULL
);

CREATE TABLE if not exists category
(
    category_id        bigserial PRIMARY KEY,
    parent_category_id bigserial   NOT NULL references category,
    name               varchar(50) NOT NULL
);
CREATE TABLE if not exists product
(
    product_id  bigserial PRIMARY KEY,
    category_id bigserial   NOT NULL references category,
    name        varchar(50) NOT NULL,
    visibly     boolean default true,
    price       money       not null,
    count       int         not null
);

CREATE TABLE if not exists delivery
(
    delivery_id bigserial PRIMARY KEY,
    name        varchar(50) NOT NULL
);
CREATE TABLE if not exists order_status
(
    order_status_id bigserial PRIMARY KEY,
    delivery_id     bigserial references delivery,
    name            varchar(50) NOT NULL
);
CREATE TABLE if not exists order_product
(
    order_product_id bigserial PRIMARY KEY,
    order_id         bigserial,
    product_id       bigserial references product,
    count            int,
    price            money,
    cost             money
);
CREATE TABLE if not exists "order"
(
    order_id        bigserial PRIMARY KEY,
    customer_id     bigserial,
    delivery_id     bigserial,
    order_status_id bigserial,
    date            date,
    cost            money,
    address         varchar(50)
)
