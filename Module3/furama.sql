drop database if exists furamaresort;
create database furamaresort;

use furamaresort;

create table vi_tri(
id int primary key,
ten_vi_tri varchar(50));

create table trinh_do(
id int primary key,
trinh_do varchar(50));

create table bo_phan(
id int primary key,
ten_bo_phan varchar(50));

create table nhan_vien(
id int primary key,
ho_ten varchar(50),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(9),
luong float,
sdt varchar(11),
email varchar(50),
dia_chi varchar(50),
foreign key(id_vi_tri) references vi_tri(id),
foreign key(id_trinh_do) references trinh_do(id),
foreign key(id_bo_phan) references bo_phan(id)
);

create table loai_khach(
id int primary key,
ten varchar(50));

create table khach_hang(
id int primary key,
id_loai_khach int,
ho_ten varchar(50),
ngay_sinh date,
so_cmnd varchar(9),
sdt varchar(11),
email varchar(50),
dia_chi varchar(50),
foreign key(id_loai_khach) references loai_khach(id)
);

create table kieu_thue(
id int primary key,
ten varchar(50),
gia int); 

create table loai_dich_vu(
id int primary key,
ten varchar(50));

create table dich_vu(
id int primary key,
dien_tich float,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue int,
id_kieu_thue int,
id_loai_dich_vu int, 
trang_thai varchar(50),
foreign key(id_kieu_thue) references kieu_thue(id),
foreign key(id_loai_dich_vu) references loai_dich_vu(id)
);

create table hop_dong(
id int primary key
);










