drop database if exists demo;
create database demo;

use demo;

create table products(
	id int primary key,
    product_code varchar(50),
    product_name varchar(50),
    product_price float,
    product_amount float,
    product_description varchar(100),
    product_status varchar(100));
    
insert into products
values	(1,"1","Bánh",200,300,null,"Có sẵn"),
		(2,"2","Kẹo",200,300,null,"Có sẵn"),
		(3,"3","Bút Bi",200,300,null,"Có sẵn"),
		(4,"4","Vở",200,300,null,"Có sẵn"),
		(5,"5","Sách",200,300,null,"Có sẵn"),
		(6,"6","Hộp Bút",200,300,null,"Có sẵn"),
		(7,"7","Bim bim",200,300,null,"Có sẵn");
        
        
-- TẠO UNIQUE INDEX CHO BẢNG
create unique index idx_code on products(product_code);



-- TẠO COMPOSITE INDEX CHO BẢNG
create index idx on products(product_name,product_price);


EXPLAIN SELECT * FROM products WHERE product_code = '6'; 
