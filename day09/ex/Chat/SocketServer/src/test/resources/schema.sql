create table products
(
    identifier integer not null UNIQUE ,
    name varchar(30) not null ,
    price integer not null
);
