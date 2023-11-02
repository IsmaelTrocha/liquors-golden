CREATE TABLE CART(
  id bigserial primary key,
  customer_id bigserial,
  FOREIGN KEY (customer_id) REFERENCES CUSTOMER (id)
);

CREATE TABLE CART_ITEM(
  id bigserial primary key,
  cart_id bigserial,
  product_id bigserial,
  FOREIGN KEY (cart_id) REFERENCES CART(id),
  FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
);