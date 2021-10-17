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
luong int,
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

insert into loai_khach
values(1,"Normal"),
(2,"Silver"),
(3,"Gold"),
(4,"Platinum"),
(5,"Diamond");

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

create table dich_vu_di_kem(
id int primary key,
ten_dich_vu varchar(50),
gia int,
don_vi int,
trang_thai varchar(50));

create table hop_dong(
id int primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id),
foreign key (id_khach_hang) references khach_hang(id),
foreign key (id_dich_vu) references dich_vu(id));

create table hop_dong_chi_tiet(
id int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id),
foreign key (id_hop_dong) references hop_dong(id));



insert into vi_tri
value(1,"Giám Đốc"),
     (2,"Nhân Viên Buồng Phòng"),
     (3,"Lễ Tân"),
     (4,"Đầu Bếp"),
     (5,"Kế Toán"),
     (6,"Kinh Doanh");

insert into trinh_do
value (1,"Thạc sĩ"),
	(2,"Tiến sĩ"),
	(3,"Cử nhân");


insert into bo_phan
value (1,"Lãnh đạo"),
	  (2,"Buồng phòng"),
	  (3,"Ẩm Thực"),
	  (4,"Lễ Tân"),
	  (5,"Kinh Doanh");


insert into khach_hang
value (1,5,"Lê Quang Thái","2000-10-26","123456789","0123456798","quangthai645@gmail.com","Đăk Lăk"),
(2,1,"Nguyễn Thành Luân","1980-11-10","123456789","0123456798","thanhluan@gmail.com","Tam Kỳ"),
(3,2,"Ngô Thành Tây","1997-06-10","123123123","01234512798","tayngo@gmail.com","Hồ Chí Minh"),
(4,3,"Phạm Minh Chiến","1963-10-02","123456789","0146789156","chienpham@gmail.com","Hà Nội"),
(5,4,"Võ Ngọc Win","1998-06-07","123456789","0687122356","quangthai645@gmail.com","Gia Lai");



insert into nhan_vien
value (1,"Lê Quang Thái",1,1,1,"2000-10-26","123456789",1000,"0123456798","quangthai645@gmail.com","Đăk Lăk"),
(2,"Trương Tiến Vũ",3,2,2,"1980-11-10","123456789",500,"0123456798","truongtien@gmail.com","Tam Kỳ"),
(3,"Huỳnh Tấn Phát",4,2,3,"1997-06-10","123456789",100,"0123456798","phat@gmail.com","Đà Nẵng"),
(4,"Nguyễn Thị Kim Ngân",6,3,5,"1963-10-02","123456789",300,"0123456798","kimngan@gmail.com","Quảng Nam"),
(5,"Trần Thị Tuyết",3,1,4,"1998-06-07","123456789",200,"0123456798","tuyettran@gmail.com","Hồ Chí Minh"),
(6,"Đỗ Thị Hà",2,null,2,"1983-03-26","123456789",50,"0123456798","dothiha@gmail.com","Hà Nội");











