-- jumin 은 앞자리와 '-' 와 뒷자리로 구성한다.
-- email 은 아이디@도메인으로 구성한다.
-- hobby 는 여러 개의 취미를 콤마로 구분한다.
-- gender 는 value 값을 m 또는 f 로 변경한다.
-- post 는 0으로 시작하는 우편번호가 있어 문자형으로 처리한다. (01234 를 숫자형으로 저장하면 1234 만 저장된다.)

create table template_join(
id 			varchar2(20) primary key,
password 	varchar2(20),
jumin		varchar2(14),
email 		varchar2(30),
gender 		char(1) check(gender in ('m','f')),
hobby 		varchar2(34),
post 		varchar2(5),
address 	varchar2(150),
intro 		varchar2(100),
register_date date default sysdate
);