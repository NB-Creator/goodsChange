CREATE DATABASE msp;

USE msp;
-- 用户表
CREATE TABLE tb_user (
	username VARCHAR (20) PRIMARY KEY,
	nickname VARCHAR (20),
	PASSWORD VARCHAR (11),
	mail VARCHAR (11),
	NAME VARCHAR (20),
	address VARCHAR (50)
);
-- 对password属性建立索引
ALTER TABLE tb_user ADD INDEX PASSWORD (PASSWORD)
-- 商品表
CREATE TABLE tb_item (
	id INT PRIMARY KEY,
	time VARCHAR (20),
	NAME VARCHAR (20),
	detail text,
	img VARCHAR (50),
	expect LONGBLOB,
	classification VARCHAR (10),
	price INT,
	uid VARCHAR (20),
	CONSTRAINT FOREIGN KEY (uid) REFERENCES tb_user (username)
);
-- 对name,price建立索引
ALTER TABLE tb_item ADD INDEX item (NAME);
ALTER TABLE tb_item ADD INDEX price(price);
-- 交换信息表
CREATE TABLE tb_exchange (
	id VARCHAR (20) PRIMARY KEY,
	uid_a VARCHAR (20),
	uid_b VARCHAR (20),
	gid_a INT,
	gid_b INT,
	date date,
	info VARCHAR (200),
	statu VARCHAR (5),
	CONSTRAINT FOREIGN KEY (uid_a) REFERENCES tb_user (username),
	CONSTRAINT FOREIGN KEY (uid_b) REFERENCES tb_user (username),
	CONSTRAINT FOREIGN KEY (gid_a) REFERENCES tb_item (id),
	CONSTRAINT FOREIGN KEY (gid_b) REFERENCES tb_item (id)
);
-- 对statu建立索引
ALTER TABLE tb_exchange ADD INDEX statu (statu)
-- 收藏表
CREATE TABLE collect (
	uid VARCHAR (20),
	gid INT (11),
	CONSTRAINT FOREIGN KEY (uid) REFERENCES tb_user (username),
	CONSTRAINT FOREIGN KEY (gid) REFERENCES tb_item (id),
	CONSTRAINT PRIMARY KEY (uid, gid)
);
-- 评论表
CREATE TABLE COMMENT (
	uid VARCHAR (20),
	gid INT (11),
	info text,
	date date,
	CONSTRAINT FOREIGN KEY (uid) REFERENCES tb_user (username),
	CONSTRAINT FOREIGN KEY (gid) REFERENCES tb_item (id),
	CONSTRAINT PRIMARY KEY (uid, gid)
)
-- 消息表
create table message(
	usernameA VARCHAR(20),
	usernameB VARCHAR(20),
	itemId VARCHAR(20),
	message text,
	CONSTRAINT PRIMARY KEY(usernameA,usernameB),
	CONSTRAINT FOREIGN KEY(usernameA) REFERENCES tb_user(username),
	CONSTRAINT FOREIGN KEY(usernameB) REFERENCES tb_user(username),
	CONSTRAINT FOREIGN KEY(itemId) REFERENCES tb_item(id)
);