CREATE TABLE customer
(
    customer_id bigint PRIMARY KEY,
    name        character varying(50) NOT NULL,
    address     character varying(50)
);
CREATE SEQUENCE customer_id_seq
    START WITH 7
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE customer_id_seq OWNED BY customer.customer_id;

ALTER TABLE ONLY customer ALTER COLUMN customer_id SET DEFAULT nextval('customer_id_seq'::regclass);

CREATE TABLE category
(
    category_id        bigint PRIMARY KEY,
    parent_category_id bigint,
    name               character varying(50) NOT NULL
);

CREATE SEQUENCE category_id_seq
    START WITH 7
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE category_id_seq OWNED BY category.category_id;

ALTER TABLE ONLY category ALTER COLUMN category_id SET DEFAULT nextval('category_id_seq'::regclass);



CREATE TABLE product
(
    product_id  bigint PRIMARY KEY,
    category_id bigint   NOT NULL,
    name        character varying(50) NOT NULL,
    visible     boolean default true,
    price       numeric       not null,
    count       int         not null
);

CREATE SEQUENCE product_id_seq
    START WITH 7
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE product_id_seq OWNED BY product.product_id;

ALTER TABLE ONLY product ALTER COLUMN product_id SET DEFAULT nextval('product_id_seq'::regclass);

CREATE TABLE delivery
(
    delivery_id bigint PRIMARY KEY,
    name       character varying(50) NOT NULL
);
CREATE SEQUENCE delivery_id_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE delivery_id_seq OWNED BY delivery.delivery_id;

ALTER TABLE ONLY delivery ALTER COLUMN delivery_id SET DEFAULT nextval('delivery_id_seq'::regclass);

CREATE TABLE order_status
(
    order_status_id bigint PRIMARY KEY,
    delivery_id     bigint,
    name            character varying(50) NOT NULL
);

CREATE SEQUENCE order_status_id_seq
    START WITH 7
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE order_status_id_seq OWNED BY order_status.order_status_id;

ALTER TABLE ONLY order_status ALTER COLUMN order_status_id SET DEFAULT nextval('order_status_id_seq'::regclass);

CREATE TABLE order_product
(
    order_product_id bigint PRIMARY KEY,
    order_id         bigint,
    product_id       bigint,
    count            int,
    price            numeric,
    cost           numeric
);
CREATE SEQUENCE order_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE order_product_id_seq OWNED BY order_product.order_product_id;

ALTER TABLE ONLY order_product ALTER COLUMN order_product_id SET DEFAULT nextval('order_product_id_seq'::regclass);

CREATE TABLE gen_order
(
    order_id        bigint PRIMARY KEY,
    customer_id     bigint,
    delivery_id     bigint,
    order_status_id bigint,
   date            date,
    cost            numeric,
    address         character varying(50)
);
CREATE SEQUENCE gen_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE gen_order_id_seq OWNED BY gen_order.order_id;

ALTER TABLE ONLY gen_order ALTER COLUMN order_id SET DEFAULT nextval('gen_order_id_seq'::regclass);
