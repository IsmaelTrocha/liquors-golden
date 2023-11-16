CREATE TABLE CATEGORY(
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP
);

CREATE TABLE STATUS(
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
 );

CREATE TABLE PROPORTION(
    id bigserial PRIMARY KEY,
    quantity VARCHAR(255) NOT NULL
 );

CREATE TABLE COUNTRIES(
   id bigserial PRIMARY KEY,
   iso VARCHAR(255) NOT NULL,
   name VARCHAR(255) NOT NULL
);

INSERT INTO COUNTRIES (id, name, iso)
VALUES (1, 'Colombia', 'CO');

CREATE TABLE CITIES(
 id bigserial PRIMARY KEY,
 name VARCHAR(255) NOT NULL,
 country_id bigserial,
 FOREIGN KEY (country_id) REFERENCES COUNTRIES(id)
);

INSERT INTO CITIES (id, name, country_id) VALUES (1, 'Cartagena', 1);

CREATE TABLE PRODUCTS(
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    stock int,
    category_id bigserial,
    creation_date TIMESTAMP,
    discount_amount int,
    price DECIMAL(10,3) NOT NULL,
    update_date TIMESTAMP,
    hide_date TIMESTAMP,
    expiry_date TIMESTAMP,
    status_id bigserial,
    proportion_id bigserial,
    alcohol_percentage DECIMAL(10,3) NOT NULL,
    iva decimal(10,3),
    consumo decimal(10,3),
    sold_units int,
    FOREIGN KEY (proportion_id) REFERENCES PROPORTION(id),
    FOREIGN KEY (category_id) REFERENCES CATEGORY(id),
    FOREIGN KEY (status_id) REFERENCES STATUS(id)
);

CREATE TABLE IMAGES(

  id bigserial PRIMARY KEY,
  file_name VARCHAR(255) NOT NULL,
  creation_date TIMESTAMP

);

CREATE TABLE CUSTOMER(
  id bigserial PRIMARY KEY,
  username VARCHAR(255)  NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  img_url VARCHAR(255) NOT NULL,
  token varchar(255) NOT NULL,
  age int NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  create_at TIMESTAMP,
  is_active boolean NOT NULL,
  role varchar(15) NOT NULL
  );

CREATE TABLE ADDRESSES(
  id bigserial PRIMARY KEY,
  street VARCHAR(255) NOT NULL,
  avenue VARCHAR(255) NOT NULL,
  city_id bigserial,
  customer_id bigserial,
  description TEXT NOT NULL,
  postal_code VARCHAR(255) NOT NULL,
  state VARCHAR(255) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
  FOREIGN KEY (city_id) REFERENCES CITIES(id)
);

CREATE TABLE ORDERS(
  id bigserial PRIMARY KEY,
  customer_id bigserial,
  address_id bigserial,
  quantity INT,
  total_price decimal(10,3),
  creation_date TIMESTAMP,
  delivery_date TIMESTAMP,
  finish_date TIMESTAMP,
  status_id bigserial,
  iva decimal(10,3),
  consumo decimal(10,3),
  total_products decimal(10,3),
  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
  FOREIGN KEY (address_id) REFERENCES ADDRESSES(id),
  FOREIGN KEY (status_id) REFERENCES STATUS(id)
  );

  -- Crear la tabla de unión para relacionar ORDERS con PRODUCTS
CREATE TABLE ORDER_PRODUCTS (
  id bigserial PRIMARY KEY,
  order_id bigserial,
  product_id bigserial,
  FOREIGN KEY (order_id) REFERENCES ORDERS(id),
  FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
  );


-- Para 330ml
INSERT INTO PROPORTION (quantity)
 VALUES ('330ml');

-- Para 375ml
INSERT INTO PROPORTION (quantity)
 VALUES ('375ml');

-- Para 750ml
INSERT INTO PROPORTION (quantity)
 VALUES ('750ml');

-- Para 1 Litro
INSERT INTO PROPORTION (quantity)
 VALUES ('1 Litro');



INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Vodka', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Whisky', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Ron', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Tequila', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Cerveza', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO CATEGORY (name, create_by, creation_date)
VALUES ('Otros', 'Ismael.trocha@hotmail.com', NOW());

INSERT INTO STATUS(name) VALUES ('ACTIVE');
