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
    FOREIGN KEY (proportion_id) REFERENCES PROPORTION(id),
    FOREIGN KEY (category_id) REFERENCES CATEGORY(id),
    FOREIGN KEY (status_id) REFERENCES STATUS(id)
);

CREATE TABLE IMAGES(
  id bigserial PRIMARY KEY,
  name VARCHAR (255) NOT NULL,
  resource VARCHAR(255) NOT NULL
);

CREATE TABLE CUSTOMER(
  id bigserial PRIMARY KEY,
  first_name VARCHAR(255)  NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  age int NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  create_at TIMESTAMP,
  enable boolean NOT NULL,
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
  product_id bigserial,
  quantity INT NOT NULL,
  total_price decimal(10,3) NOT NULL,
  creation_date TIMESTAMP,
  delivery_date TIMESTAMP,
  finish_date TIMESTAMP,
  status_id bigserial,
  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
  FOREIGN KEY (address_id) REFERENCES ADDRESSES(id),
  FOREIGN KEY (status_id) REFERENCES STATUS(id),
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


INSERT INTO STATUS(name) VALUES ('ACTIVE');
-- Insert 1: Aguardiente Antioqueño
INSERT INTO PRODUCTS (name, description, image_url, stock, category_id, creation_date, discount_amount, price, update_date, hide_date, expiry_date, status_id, proportion_id)
VALUES ('Aguardiente Antioqueño', 'Aguardiente tradicional de Antioquia', 'aguardiente_antioqueno.jpg', 100, 1, NOW(), 0, 250.00, NOW(), NOW(), NOW(), 1, 1);

-- Insert 2: Ron Medellín
INSERT INTO PRODUCTS (name, description, image_url, stock, category_id, creation_date, discount_amount, price, update_date, hide_date, expiry_date, status_id, proportion_id)
VALUES ('Ron Medellín', 'Ron añejo de Medellín', 'ron_medellin.jpg', 75, 3, NOW(), 0, 80.00, NOW(), NOW(), NOW(), 1, 1);

-- Insert 3: Cerveza Club Colombia Dorada
INSERT INTO PRODUCTS (name, description, image_url, stock, category_id, creation_date, discount_amount, price, update_date, hide_date, expiry_date, status_id, proportion_id)
VALUES ('Cerveza Club Colombia Dorada', 'Cerveza rubia premium', 'cerveza_club_colombia.jpg', 120, 5, NOW(), 0, 45.00, NOW(), NOW(), NOW(), 1, 1);

-- Insert 4: Aguardiente Néctar
INSERT INTO PRODUCTS (name, description, image_url, stock, category_id, creation_date, discount_amount, price, update_date, hide_date, expiry_date, status_id, proportion_id)
VALUES ('Aguardiente Néctar', 'Aguardiente de la región Caribe', 'aguardiente_nectar.jpg', 90, 1, NOW(), 0, 220.00, NOW(), NOW(), NOW(), 1, 1);

-- Insert 5: Tequila Sol de México
INSERT INTO PRODUCTS (name, description, image_url, stock, category_id, creation_date, discount_amount, price, update_date, hide_date, expiry_date, status_id, proportion_id)
VALUES ('Tequila Sol de México', 'Tequila 100% agave azul', 'tequila_sol_de_mexico.jpg', 60, 4, NOW(), 0, 70.00, NOW(), NOW(), NOW(), 1, 1);
