drop table member cascade constraints purge;
-- 1. index.jsp 에서 시작한다.
-- 2. 관리자 계정 admin, 비번 1234 만든다.
-- 3. 사용자 계정 3개를 만든다.

create table member(
	id				varchar2(12),
	password		varchar2(10),
	name			varchar2(15),
	age 			number(2),
	gender			varchar2(3), -- 남, 여
	email			varchar2(30), -- hta@hta.com
	memberfile		varchar2(50),
	PRIMARY KEY(id)
);

select * from member;

insert into member
(id, password, name, age, gender, email)
values ('admin', '1234', 'admin', 30, '남', 'hta@hta.com');

insert into member
(id, password, name, age, gender, email)
values ('user1', '1234', '홍길동', 20, '남', 'hong@hta.com');

insert into member
(id, password, name, age, gender, email)
values ('user2', '1234', '신사임당', 40, '여', 'sin@hta.com');

insert into member
(id, password, name, age, gender, email)
values ('user3', '1234', '이순신', 50, '남', 'lee@hta.com');


select count(*)
from member
where id != 'admin'
and name like '%홍길동%';







