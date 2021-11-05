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
foreign key(id_vi_tri) references vi_tri(id) ON DELETE CASCADE,
foreign key(id_trinh_do) references trinh_do(id) ON DELETE CASCADE,
foreign key(id_bo_phan) references bo_phan(id) ON DELETE CASCADE);

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

create table hop_dong (
id int primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id) ON DELETE CASCADE,
foreign key (id_khach_hang) references khach_hang(id) ON DELETE CASCADE,
foreign key (id_dich_vu) references dich_vu(id) ON DELETE CASCADE);


create table hop_dong_chi_tiet(
id int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id) ON DELETE CASCADE ,
foreign key (id_hop_dong) references hop_dong(id) ON DELETE CASCADE);

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
(6,"Bronze"),
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
values (1,1,5,2,"2019-10-17","2019-10-20",null,1000000),
       (2,2,4,1,"2019-01-16","2019-2-22",null,1500000),
       (3,6,2,3,"2021-10-10","2021-10-16",null,3000000),
	   (4,3,1,1,"2019-02-16","2019-2-22",null,5000000),
	   (5,4,3,1,"2015-03-16","2019-2-22",null,4500000),
	   (6,5,2,1,"2019-02-16","2019-2-22",null,3500000),
	   (7,2,1,1,"2019-01-16","2019-2-22",null,1500000),
       (8,6,2,3,"2021-10-10","2021-10-16",null,2000000);

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
 /*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien */
 SELECT kh.id, kh.ho_ten, lk.ten, hd.id, ldv.ten, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, (dv.chi_phi_thue+ hdct.so_luong*dvdk.gia) as "Tong Tien"
 from khach_hang kh
 left join hop_dong hd on kh.id = hd.id_khach_hang
 left join loai_khach lk on kh.id_loai_khach = lk.id
 left join dich_vu dv on dv.id = hd.id_dich_vu
 left join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id
 left join hop_dong_chi_tiet hdct on hd.id = hdct.id_hop_dong
 left join dich_vu_di_kem dvdk on dvdk.id = hdct.id_dich_vu_di_kem
 group by kh.id;
 
 
 
 /*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019*/
select dv.id, dv.dien_tich, dv.chi_phi_thue, ldv.ten
from dich_vu dv
inner join loai_dich_vu ldv on ldv.id = dv.id_loai_dich_vu
inner join hop_dong hd on hd.id_dich_vu = dv.id
where year(hd.ngay_lam_hop_dong)=2019 and dv.id not in (select hd.id_dich_vu from hop_dong hd where (month(hd.ngay_lam_hop_dong)=1 or month(hd.ngay_lam_hop_dong)=2 or month(hd.ngay_lam_hop_dong)=3) and year(hd.ngay_lam_hop_dong)=2019);
 
 
 /*7.	Hiển thị thông tin của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.*/
 
create view dich_vu_2018 as
select dv.id 'id_dich_vu', dv.dien_tich, dv.chi_phi_thue
from dich_vu dv
inner join hop_dong hd on hd.id_dich_vu = dv.id
where year(hd.ngay_lam_hop_dong)=2019;
 
select dv.id, dv.dien_tich,dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten
from dich_vu dv
inner join loai_dich_vu ldv on ldv.id = dv.id_loai_dich_vu
inner join hop_dong hd on hd.id_dich_vu = dv.id
where year(hd.ngay_lam_hop_dong)=2018 and dv.id not in (select id_dich_vu from dich_vu_2018);
 
 /*8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau. Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/
 /*Cách 1*/
 select distinct ho_ten from khach_hang;
 
 /*Cách 2*/
 select ho_ten from khach_hang
 group by ho_ten;
 
/*9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/


select month(ngay_lam_hop_dong) as "thang",count(id_khach_hang) as "so_khach_hang_dat_phong"
from hop_dong
where year(ngay_lam_hop_dong)=2019
group by ngay_lam_hop_dong;

/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm*/ 

select hd.id, hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc, count(hdct.id)
from hop_dong hd
right join hop_dong_chi_tiet hdct on hdct.id_hop_dong =hd.id;

 
 /*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”*/
 
 
 select ldv.ten, dv.dien_tich, dv.so_tang, dv.so_nguoi_toi_da, dv.chi_phi_thue
 from khach_hang kh
 inner join hop_dong hd on kh.id = hd.id_khach_hang
 inner join loai_khach lk on kh.id_loai_khach = lk.id
 inner join dich_vu dv on dv.id = hd.id_dich_vu
 inner join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id
 where lk.ten = "Diamond" and (kh.dia_chi = "Tam Kỳ" or kh.dia_chi ="Vũng Tàu");
 
/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ */
 
 select hd.id, nv.ho_ten as "Ten_Nhan_Vien", kh.ho_ten as "Ten_Khach_Hang", kh.sdt, ldv.ten, count(hdct.id) as "So_Luong_Dich_Vu_Di_kem",hd.tien_dat_coc
 from hop_dong hd
 inner join nhan_vien nv on hd.id_nhan_vien = nv.id
 inner join khach_hang kh on kh.id = hd.id_khach_hang
 inner join dich_vu dv on hd.id_dich_vu = dv.id
 inner join loai_dich_vu ldv on ldv.id = dv.id_loai_dich_vu
 inner join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id 
 where hd.ngay_lam_hop_dong between "2019-10-01" and "2019-12-31" and  dv.id not in (select dv.id from dich_vu dv inner join hop_dong hd on hd.id_dich_vu = dv.id where hd.ngay_lam_hop_dong between "2019-06-01" and "2019-06-31")
 group by hd.id ;
 
 
 /*13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng*/
 

 
 select d.id, d.ten_dich_vu,d.gia,d.don_vi, count(hdct.id) as "so_lan_su_dung"
 from dich_vu_di_kem d
 join hop_dong_chi_tiet hdct on d.id = hdct.id_dich_vu_di_kem
 group by d.id
 having so_lan_su_dung >= all (select count(hdct.id) from hop_dong_chi_tiet hdct
								group by hdct.id_dich_vu_di_kem);
 

 /*14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
 
select dvdk.ten_dich_vu, hd.id, dvdk.ten_dich_vu, count(dvdk.id)
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id = hdct.id_dich_vu_di_kem
join hop_dong hd on hd.id = hdct.id_hop_dong
group by dvdk.id
having count(dvdk.id) = 1;
 
/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
 
 select nv.id, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi, count(hd.id_nhan_vien) as "so_lan_tao_hop_dong"
 from nhan_vien nv
 join trinh_do td on td.id = nv.id_trinh_do
 join bo_phan bp on bp.id = nv.id_bo_phan
 join hop_dong hd on nv.id = hd.id_nhan_vien
 where (year(hd.ngay_lam_hop_dong) between 2018 and 2019)
 group by hd.id_nhan_vien
 having count(hd.id_nhan_vien) <=3;
 
 /*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019*/
 
delete from nhan_vien nv
where not exists (select hd.id_nhan_vien from hop_dong hd
					where year(hd.ngay_lam_hop_dong) between 2017 and 2019);
 
 
 /*17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ*/
 
-- create view tong_tien as
 create view upgrade_vip as
 select kh.id, sum(hd.tong_tien)
 from khach_hang kh
 inner join hop_dong hd on kh.id = hd.id_khach_hang
 where year(hd.ngay_lam_hop_dong) =2019
 group by kh.id having sum(hd.tong_tien)>5000000;
 
 update khach_hang
 set id_loai_khach =5 
 where id_loai_khach =4 and id in (select khach_hang.id from upgrade_vip);



/* 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).*/
delete from khach_hang
where khach_hang.id in (select hop_dong.id_khach_hang from hop_dong where year(ngay_lam_hop_dong) <=2016);



/*19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi*/
update dich_vu_di_kem
set gia = gia*2
where id in (select id_dich_vu_di_kem from hop_dong_chi_tiet group by id_dich_vu_di_kem having count(id_dich_vu_di_kem)>=2);



/*20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/


select n.id,n.ho_ten, n.email,n.sdt,n.ngay_sinh,n.dia_chi
from nhan_vien n
union
select k.id,k.ho_ten, k.email,k.sdt,k.ngay_sinh,k.dia_chi
from khach_hang k;




select * from nhan_vien;


select nv.id, nv.ho_ten, vt.id, vt.ten_vi_tri,td.id, td.trinh_do,bp.id,bp.ten_bo_phan,ngay_sinh, so_cmnd, luong,sdt,email,dia_chi
from nhan_vien nv
join vi_tri vt on nv.id_vi_tri = vt.id
join trinh_do td on td.id = nv.id_trinh_do
join bo_phan bp on bp.id = nv.id_bo_phan