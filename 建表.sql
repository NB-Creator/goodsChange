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
	img LONGBLOB,
	expect LONGBLOB,
	classification VARCHAR(10),
	price int,
	uid VARCHAR(20),
	CONSTRAINT FOREIGN KEY(uid) REFERENCES tb_user(username)
);