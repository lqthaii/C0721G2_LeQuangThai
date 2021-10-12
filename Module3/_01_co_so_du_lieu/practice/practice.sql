create database my_database;
/*bài tạo database*/
use my_database;

create table student(
id int not null,
`name` varchar(50),
age int null,
country varchar(50) null,
primary key(id)
);
/*bài tạo bảng*/

create database my_database1;
drop database my_database1;
/*bài xoá database*/