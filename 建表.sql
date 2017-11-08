CREATE DATABASE msp;
use msp;
create TABLE tb_user(
  username VARCHAR(20) PRIMARY KEY,
	nickname varchar(20),	
  password VARCHAR(11),
  mail varchar(11),
	name varchar(20),
	address VARCHAR(50)
);

create table tb_item(
	id int PRIMARY key,
	time varchar(20),
	name varchar(20),
	detail text,
	img varchar(50),
	expect LONGBLOB,
	classification VARCHAR(10),
	price int,
	uid VARCHAR(20),
	CONSTRAINT FOREIGN KEY(uid) REFERENCES tb_user(username)
);


create table tb_exchange(
id varchar(20) PRIMARY KEY,
uid_a varchar(20),
uid_b varchar(20),
gid_a int,
gid_b int,
date date,
info varchar(200),
statu varchar(5),
CONSTRAINT FOREIGN KEY(uid_a) REFERENCES tb_user(username),
CONSTRAINT FOREIGN KEY(uid_b) REFERENCES tb_user(username),
CONSTRAINT FOREIGN KEY(gid_a) REFERENCES tb_item(id),
CONSTRAINT FOREIGN KEY(gid_b) REFERENCES tb_item(id)
);