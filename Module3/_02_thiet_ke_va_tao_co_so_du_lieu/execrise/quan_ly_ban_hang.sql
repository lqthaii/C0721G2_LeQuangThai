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
primary key(order_id,product_id),
foreign key (order_id) references `Order`(id),
foreign key (product_id) references product(id));