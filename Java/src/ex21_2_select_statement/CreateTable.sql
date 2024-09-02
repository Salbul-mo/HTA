drop table emp_copy purge;
-- 한 문장 실행 Alt s

create table emp_copy
as select * from emp;
-- 여러 문장 실행 Alt x

create or replace function working_years
(vempno emp.empno%type)
	return number -- return 에는 ; 안붙인다.
is 
	vyear number; -- 스칼라는 ; 붙인다.
begin
	select floor((sysdate-hiredate)/365)
	into vyear
	from emp_copy
	where empno = vempno;
	return vyear;
end;
-- jdbc 에서는 /를 사용하지 않는다.
-- 여러개의 세미콜론이 있는 경우 한 문장으로 실행 Alt c

select working_years(7788) from dual;
-- 한 문장 실행은 커서 위치하고 Alt s

