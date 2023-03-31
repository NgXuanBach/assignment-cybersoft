-- Tạo databse 
CREATE database vnexpress;
use vnexpress;
-- chi dinh database duoc su dung 
create table users(
	id bigint auto_increment,
	hoten varchar(255) not null,
	gioitinh varchar(3),
	ngaytao timestamp default current_timestamp,
	
	-- Audit: check du lieu ai chinh sua ngay nao, gio nao, tuong tac.
	-- chi dinh 1 hoac nhieu cot la khoa chinh
	primary key(id)
);
CREATE table userdetail(
	user_id bigint,
	sodienthoai varchar(10),
	diachi varchar(50),
	dienthoaiban varchar(10),
	
	primary key(user_id),
	constraint FK_userdetail_user_id foreign key(user_id) references users(id)
)
create table baiviet(
	id bigint auto_increment,
	tieude varchar(255),
	noidung text,
	ngaytao timestamp default current_timestamp,
	tentacgia varchar(255),
	
	primary key (id)
);
CREATE table comment(
	id bigint auto_increment,
	noidung
	text,
	user_id bigint,
	baiviet_id bigint,
	
	primary key(id)
)
-- xoa bang 
drop table users;

-- chinh sua bang
--   them cot moi : add column ten_cot kieu_du_lieu  
ALTER table users add column ngaychinhsua timestamp default  current_timestamp;
ALTER table baiviet add column user_id bigint;

-- add them khoa ngoai sau ko nen add khoa ngoai tai luc tao table.
ALTER table baiviet add constraint FK_baiviet_user_id foreign key(user_id) references users(id);

ALTER table comment add constraint FK_comment_user_id foreign key(user_id) references users(id);
ALTER table comment add constraint FK_comment_baiviet_id foreign key(baiviet_id) references baiviet(id);

-- insert du lieu vao bang 
insert into users(hoten,gioitinh) values("Nguyen Van B",0);


-- cau query, truy van du lieu
-- *: lay toan bo cot trong bang 
SELECT * from users;	

-- Join , left join , right join 
SELECT * 
FROM users s
join userdetail u on s.id = u.user_id ;


SELECT *
from users s
join baiviet b on s.id =b.user_id
join comment c on c.user_id  =s.id  ;

-- viet cau query them du lieu vao bang bai viet
insert into baiviet(tieude,noidung,tentacgia) values("tieude1","abc","Nguyen Van A");
insert into baiviet(tieude,noidung,tentacgia) values("tieude2","abcd","Nguyen Van B");


insert into userdetail (user_id,sodienthoai,diachi) values(2,"05123","123 Su Van Hanh");


insert into comment  (noidung,user_id,baiviet_id) values("Noi dung 1",2,1);
insert into comment  (noidung,user_id,baiviet_id) values("Noi dung 2",2,1);
insert into comment  (noidung,user_id,baiviet_id) values("Noi dung 3",2,2);


-- xoa du lieu cua mot bang
DELETE FROM users WHERE hoten="Nguyen Van B" ;

UPDATE baiviet set user_id = 2 where id = 1;
SELECT * from users;	
SELECT * from userdetail;
SELECT * from baiviet ;
SELECT * from comment;
-- dat aslias: as ten_tu_dat
SELECT * from users as u, baiviet as b_
WHERE u.hoten = b.tentacgia;


-- Moi quan he giua 2 bang:
-- One To One: 1 dong du lieu cua bang nay chi lay dc 1 dong du lieu cua bang kia
-- One To Many: 1 dong du lieu cua bang nay lay dc nhieu dong du lieu cua bang kia va nguoc lai
-- Many To One:
-- Many TO Many: se phat sinh bang trung gian 
