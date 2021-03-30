drop database if exists servlet_blog;
create database servlet_blog character set utf8mb4;
use servlet_blog;
create table user(
 id int primary key auto_increment,
 username varchar(20) not null unique comment'账号',
 password varchar(20) not null,
 nickname varchar(20),
 sex bit,
 birthday date,
 head varchar(50)
);

create table article(
    id int primary key auto_increment,
    title varchar(20) not null,
    content mediumtext not null,
    create_time timestamp default now(),
    view_count int,
    user_id int,
    foreign key(user_id) references user(id)

);
insert into user (username,password) values('a','1');
insert into user (username,password) values('b','2');
insert into user (username,password) values('c','3');
insert into article(title,content,user_id) values('快速排序','public...',1);
insert into article(title,content,user_id) values('快速排序','public...',1);
insert into article(title,content,user_id) values('快速排序','public...',1);
insert into article(title,content,user_id) values('快速排序','public...',2);
insert into article(title,content,user_id) values('快速排序','public...',2);
/*主外键关联的表，默认创建的主外键的约束是restrict严格模式，比如从表有关数据关联到主表某一数据x，那么x就会报错*/
/*真实的设计是不删除物理物理，再每一张表上设计一个字段，表示是否有效*/


select id, username, password, nickname, sex, birthday, head from user where username='a';
select id, title from article where user_id=1;