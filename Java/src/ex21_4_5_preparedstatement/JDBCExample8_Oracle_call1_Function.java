package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample8_Oracle_call1_Function {

	public static void main(String[] args) {
		Connection conn = null;
		/*
		 * SQL FUNCTION CAL_BONUS
		 *  
		 * CREATE OR REPLACE FUNCTION CAL_BONUS(VEMPNO IN EMP.EMPNO%TYPE)
		 * 
		 * RETURN NUMBER -- 함수에 의해 되돌려지는 값의 타입
		 * 
		 * IS
		 * 		VSAL NUMBER(7,2); -- 스칼라 변수
		 * 
		 * BEGIN
		 * 		SELECT SAL 
		 * 		INTO VSAL -- 스칼라 변수에 삽입
		 * 		FROM EMP
		 * 		WHERE EMPNO=VEMPNO; -- IN 매개변수와 같은 행의 데이터를
		 * 
		 * 		RETURN (VSAL * 2); -- 삽입된 값에 2배를 하고 리턴.
		 * 
		 * END;
		 */
		/*
		 *  1.  저장 프로시저 및 함수 호출
		 *		데이터 베이스에 미리 작성된 프로시저나 함수를 호출할 때 CallableStatement를 사용한다.
		 * 
		 *	2.	IN/OUT 파라미터 처리
		 *		프로시저나 함수는 입력(IN) 파라미터와 출력(OUT) 파라미터를 받을 수 있다.
		 *		CallableStatement 는 이러한 파라미터를 설정하거나 결과로 받을 수 있다.
		 *
		 * 	3.	쿼리 실행 및 결과 처리
		 * 		일반 쿼리처럼 실행하여 결과를 얻을 수 있다.
		 * 
		 */
		CallableStatement cstmt = null;
		
		try {
			
			// JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			// 데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			// VARIABLE VAR_RES NUMBER;
			// EXECUTE :VAR_RES := CAL_BONUS(7788);
			cstmt = conn.prepareCall("{? = call CAL_BONUS(?)}"); // 함수 호출 문 (첫 번째 ? 는 반환값)
			
			// 첫 번째 ? 에 반환값의 타입 설정
			cstmt.registerOutParameter(1, Types.NUMERIC);
			
			// 입력 파라미터 설정
			cstmt.setInt(2,7788); 
			
			// 함수 실행
			cstmt.execute();
			
			// 반환 값 얻기 (첫 번째 ? 에서 값을 가져온다.)
			double salary = cstmt.getDouble(1); // 첫 번째 ?에서 값을 반환 받는다.
			System.out.println("7788의 BONUS 급여 : " + salary);
		}catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
			cnfe.printStackTrace();
		}catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			if (cstmt != null) 
				try {
					cstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
	}
}
