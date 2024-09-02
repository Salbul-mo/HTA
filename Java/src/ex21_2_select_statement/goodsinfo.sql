-- 실행 방법
-- 1. 한 문장 실행의 경우는 커서를 문장 위에 놓고 마우스 우클릭 -> Execute Current Text(Alt + S)
drop table goodsinfo purge;
/*
해당하는 테이블이 없을 때
drop table goodsinfo purge


ORA-00942: table or view does not exist
(0 rows affected)
*/

-- 2. 여러 문장 실행의 경우
--		영역 설정 후 마우스 우클릭 -> Execute Selected Text (Alt + X)

create table goodsinfo(
	code varchar2(5) primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);

/*
create table goodsinfo(
	code varchar2(5) primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
)
(0 rows affected)
Elapsed Time:  0 hr, 0 min, 0 sec, 1 ms. 

SCOTT>desc goodsinfo
 Name                                                                                Null?    Type
 ----------------------------------------------------------------------------------- -------- -----------------
 CODE                                                                                NOT NULL VARCHAR2(5)
 NAME                                                                                NOT NULL VARCHAR2(30)
 PRICE                                                                               NOT NULL NUMBER(8)
 MAKER                                                                                        VARCHAR2(20)
*/

/*SCOTT>select * from goodsinfo;

CODE       NAME       PRICE      MAKER
---------- ---------- ---------- ----------------------------------------
10001      디지털  TV   350000      LG
10002      DVD 플레이어  250000     LG
10003      디지털 카메라  210000     삼성
10004      전자사전      180000     아이리버
10005      벽걸이 에어컨  400000     삼성
*/
insert into goodsinfo
values('10001','디지털  TV', 350000,'LG');

insert into goodsinfo
values('10002','DVD 플레이어', 250000,'LG');

insert into goodsinfo
values('10003','디지털 카메라', 210000,'삼성');

insert into goodsinfo
values('10004','전자사전', 180000,'아이리버');

insert into goodsinfo
values('10005','벽걸이 에어컨', 400000,'삼성');

/*
Group Execution

insert into goodsinfo
values('10001','디지털  TV', 350000,'LG')
insert into goodsinfo
values('10002','DVD 플레이어', 250000,'LG')
insert into goodsinfo
values('10003','디지털 카메라', 210000,'삼성')
insert into goodsinfo
values('10004','전자사전', 180000,'아이리버')
insert into goodsinfo
values('10005','벽걸이 에어컨', 400000,'삼성')

Elapsed Time:  0 hr, 0 min, 0 sec, 11 ms.
*/

select * from goodsinfo;

-- 3. 함수나 프로시저 생성처럼 세미콜론으로 끝나는 문장이 여러 개 포함되는 경우
--		영역 설정 후 마우스 우클릭
--		Execute Selected Text As One Statement(Alt + C)

create or replace function working_years(vempno emp.empno%type)
	return number
is
	vyear number;
begin
	select floor((sysdate-hiredate)/365) -- 현재 시스템 날짜에서 hiredate 빼고 1년 단위로 나눈 후 floor
	into vyear
	from emp
	where empno=vempno;
	return vyear;
end;
-- jdbc 에서는 / 를 사용하지 않는다.

-- 4. 한 문장 실행의 경우는 커러를 문장 위에 놓고 마우스 우클릭 -> Execute Current Text(Alt + S)
select working_years(7788) from dual;

select * 
from goodsinfo 
where name = '디지털  TV';
