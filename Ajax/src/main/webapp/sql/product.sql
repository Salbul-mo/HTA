drop table products purge;
create table products(
id	number(2) primary key,
name	varchar2(50),
price	number,
maker	varchar2(50)
);

