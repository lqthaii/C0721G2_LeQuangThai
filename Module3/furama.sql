drop database if exists furamaresort;
create database furamaresort;

use furamaresort;

/*TẠO TABLE*/
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

/*THÊM DATA VÀO DATABASE*/

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

insert into loai_khach
values(1,"Normal"),
(2,"Silver"),
(3,"Gold"),
(4,"Platinum"),
(5,"Diamond");

insert into kieu_thue
values(1,"Ngày",100),
	  (2,"Tuần",600),
	  (3,"Tháng",30000);

insert into loai_dich_vu
values (1, "Villa"),
	   (2, "House"),
	   (3, "Room");

insert into dich_vu
values (1,300,2,3,500,1,1,"Trống"),
		(2,400,3,5,800,2,2,"Trống"),
		(3,300,2,1,500,3,2,"Trống");
        
insert into dich_vu_di_kem
values(1,"Ăn Sáng",0,2,"OK"),
	  (2,"Massage",1000,1,"OK");

insert into khach_hang
value (1,5,"Lê Quang Thái","2000-10-26","123456789","0123456798","quangthai645@gmail.com","Đăk Lăk"),
(2,5,"Nguyễn Thành Luân","1980-11-10","123456789","0123456798","thanhluan@gmail.com","Tam Kỳ"),
(3,2,"Ngô Thành Tây","1997-06-10","123123123","01234512798","tayngo@gmail.com","Quảng Trị"),
(4,3,"Phạm Minh Chiến","1963-10-02","123456789","0146789156","chienpham@gmail.com","Hà Nội"),
(5,4,"Võ Ngọc Win","1998-06-07","123456789","0687122356","quangthai645@gmail.com","Đà Nẵng");



insert into nhan_vien
value (1,"Lê Quang Thái",1,1,1,"2000-10-26","123456789",1000,"0123456798","quangthai645@gmail.com","Đăk Lăk"),
(2,"Trương Tiến Vũ",3,2,2,"1980-11-10","123456789",500,"0123456798","truongtien@gmail.com","Tam Kỳ"),
(3,"Huỳnh Tấn Phát",4,2,3,"1997-06-10","123456789",100,"0123456798","phat@gmail.com","Đà Nẵng"),
(4,"Nguyễn Thị Kim Ngân",6,3,5,"1963-10-02","123456789",300,"0123456798","kimngan@gmail.com","Quảng Nam"),
(5,"Trần Thị Tuyết",3,1,4,"1998-06-07","123456789",200,"0123456798","tuyettran@gmail.com","Hồ Chí Minh"),
(6,"Đỗ Thị Hà",2,null,2,"1983-03-26","123456789",50,"0123456798","dothiha@gmail.com","Hà Nội");



insert into hop_dong
values (1,1,5,2,"2019-10-17","2019-10-20",null,null),
       (2,2,3,1,"2019-01-16","2019-2-22",null,null),
       (3,6,2,3,"2021-10-10","2021-10-16",null,null);

insert into hop_dong_chi_tiet
values (1,1,null,null),
		(2,2,1,3),
        (3,3,2,1);


/*TRUY XUẤT DATABASE*/
/*2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

SELECT * FROM nhan_vien
WHERE (ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%") and length(ho_ten) <=15 ;


/*3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/


SELECT * FROM khach_hang
WHERE ((DATEDIFF(NOW(),ngay_sinh)/365) >=18 and (DATEDIFF(NOW(),ngay_sinh)/365) <=50) and (dia_chi = "Đà Nẵng" or dia_chi = "Quảng Trị");

 /*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
 
 SELECT khach_hang.ho_ten, count(khach_hang.ho_ten)
 FROM khach_hang
 inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id
 inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id
 where loai_khach.id = 5
 group by khach_hang.ho_ten
 order by count(khach_hang.ho_ten);
 /**/
 SELECT kh.id, kh.ho_ten, lk.ten, hd.id, ldv.ten, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, (dv.chi_phi_thue+ hdct.so_luong*dvdk.gia) as "Tong Tien"
 from khach_hang kh
 inner join loai_khach lk on kh.id_loai_khach = lk.id
 inner join hop_dong hd on kh.id = hd.id_khach_hang
 inner join dich_vu dv on dv.id = hd.id_dich_vu
 inner join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id
 inner join hop_dong_chi_tiet hdct on hd.id = hdct.id_hop_dong
 inner join dich_vu_di_kem dvdk on dvdk.id = hdct.id_dich_vu_di_kem;
 
select dv.id, dv.dien_tich, dv.chi_phi_thue, ldv.ten
from dich_vu dv
inner join loai_dich_vu ldv on ldv.id = dv.id_loai_dich_vu
inner join hop_dong hd on hd.id_dich_vu = dv.id
where year(hd.ngay_lam_hop_dong)=2019 and dv.id not in (select hd.id_dich_vu from hop_dong hd where (month(hd.ngay_lam_hop_dong)=1 or month(hd.ngay_lam_hop_dong)=2 or month(hd.ngay_lam_hop_dong)=3) and year(hd.ngay_lam_hop_dong)=2019);
 
 
 
 
 
 
 
 