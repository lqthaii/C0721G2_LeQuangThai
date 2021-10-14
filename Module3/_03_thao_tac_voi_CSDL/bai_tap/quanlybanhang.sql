drop database if exists quanlybanhang;
create database quanlybanhang;

use quanlybanhang;

create table Customer(
id int primary key auto_increment,
`name` varchar(50),
age int);


create table `Order`(
id int primary key,
`date` date,
customer_id int,
total_price float,
foreign key(customer_id) references Customer(id)
);


create table product(
id int primary key,
`name` varchar(50),
price float);


create table orderdetail(
order_id int,
product_id int,
odQTY int,
primary key(order_id,product_id),
foreign key (order_id) references `Order`(id),
foreign key (product_id) references product(id));


insert into Customer
values (1,"Minh Quan", 10),
	  (2,"Ngoc Oanh", 20),
	  (3,"Hong Ha", 50);

insert into `Order`
values (1,"2006-03-21",1,null),
	  (2,"2006-03-23",2,null),
	  (3,"2006-03-16",1,null);

insert into product 
values (1,"May Giat",3),
	   (2,"Tu Lanh",5),
	   (3,"Dieu Hoa",7),
	   (4,"Quat",1),
	   (5,"Bep Dien",2);

insert into orderdetail
values (1,1,3),
	   (1,3,7),
	   (1,4,2),
	   (2,1,1),
	   (3,1,8),
	   (2,5,4),
	   (2,3,3);
       
select id,`date`,total_price from `Order`;

select Customer.`name`,product.name 
from Customer 
inner join `order`
on Customer.id = `order`.customer_id
inner join orderdetail
on `order`.id = orderdetail.order_id
inner join product
on orderdetail.product_id = product.id
ORDER by Customer.`name` ASC;
/*Cách 1*/
select * from Customer 
where Customer.id not in (select `order`.customer_id from `order`);
/*Cách 2*/
select * from Customer
left join `order`
on Customer.id = `order`.id
where Customer.id not in (select customer_id from `order`);

select `order`.id, `order`.`date`, sum(orderdetail.odQTY*product.price) as totalPrice
from `order`
inner join orderdetail on `order`.id = orderdetail.order_id
inner join product on orderdetail.product_id = product.id
group by `order`.id;




