CREATE OR REPLACE PROCEDURE GET_EMP
(VEMPNO IN EMP.EMPNO%TYPE,
 VENAME OUT EMP.ENAME%TYPE,
 VSAL OUT EMP.SAL%TYPE)
 
IS
BEGIN
	SELECT ENAME, SAL
	INTO 	VENAME, VSAL
	FROM 	EMP
	WHERE	EMPNO = VEMPNO;
END;
