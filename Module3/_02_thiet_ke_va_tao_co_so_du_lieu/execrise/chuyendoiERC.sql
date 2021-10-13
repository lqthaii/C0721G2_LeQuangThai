drop database if exists quanlybanhang;
create database quanlybanhang;
use quanlybanhang;

create table phieuxuat(
so_px int primary key,
ngay_xuat date
);

create table vattu(
ma_vt int primary key,
ten_vt varchar(50));

create table xuat(
so_px int,
ma_vt int,
dgia_xuat float,
sl_xuat int,

primary key (so_px,ma_vt), /*câu lệnh này để cài khoá chính cho table*/

foreign key (so_px) references phieuxuat(so_px),
foreign key (ma_vt) references vattu(ma_vt)
);

create table phieunhap(
so_pn int primary key,
ngay_nhap date);

create table nhap(
ma_vt int,
so_pn int,
don_gia_nhap float,
sl_nhap int,
primary key(ma_vt,so_pn),
foreign key(ma_vt) references vattu(ma_vt),
foreign key(so_pn) references phieunhap(so_pn)
);

create table sdt(
number_phone varchar(11) primary key,
`name` varchar(50));

create table nhacungcap(
ma_cc int primary key,
ten_ncc varchar(50),
dia_chi varchar(50),
number_phone varchar(11),
foreign key(number_phone) references sdt(number_phone)
);
create table dondathang(
so_dh int primary key,
ngay_dh date,
nha_cc int,
foreign key(nha_cc) references nhacungcap(ma_cc)
);
create table dathang(
so_dh int,
ma_vt int,
primary key(so_dh,ma_vt),
foreign key(so_dh) references dondathang(so_dh),
foreign key(ma_vt) references vattu(ma_vt));
