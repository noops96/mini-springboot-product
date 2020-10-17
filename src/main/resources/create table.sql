create table product_type(id serial primary key,
name varchar(255),created_at timestamp);

create table product(id serial primary key,
name varchar(255),seller_id integer , product_type_id integer,created_at timestamp,
CONSTRAINT fk FOREIGN KEY (product_type_id) REFERENCES product_type(id));

insert into product_type(name,created_at) values ('Makanan',now());
insert into product_type(name,created_at) values ('Elektronik',now());
insert into product_type(name,created_at) values ('Game',now());
insert into product_type(name,created_at) values ('Sembako',now());