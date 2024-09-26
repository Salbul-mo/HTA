select dname as 부서이름, ename as 사원이름, deptno as 부서번호, sal as 급여
from emp natural join dept
order by 부서이름;
