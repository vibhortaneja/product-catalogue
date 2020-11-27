CREATE SCHEMA product;
CREATE TABLE product.product_details_entity (id BIGSERIAL PRIMARY KEY, productname varchar NOT NULL, price real NOT NULL, color varchar NOT NULL, brand varchar NOT NULL, size integer NOT NULL);



insert into product.product_details_entity values(2,'jeans',1500,'black','levis',32);
insert into product.product_details_entity values(3,'t-shirt',1800,'red','lp',38);
insert into product.product_details_entity values(4,'jeans',1900,'red','lp',40);
insert into product.product_details_entity values (5,'t-shirt',1100,'blue','levis',38);
insert into product.product_details_entity values(6,'t-shirt',1200,'red','vans',44);
insert into product.product_details_entity values(7,'jeans',1000,'black','vans',32);
insert into product.product_details_entity values(8,'jeans',1000,'blue','roadster',40);
insert into product.product_details_entity values(9,'t-shirt',900,'blue','lp',44);
insert into product.product_details_entity values(10,'t-shirt',700,'black','lp',38);


