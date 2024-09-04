package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample8_Oracle_call2_Procedure {

	public static void main(String args[]) {
		
		/* 프로시저 생성
		 * 
		 * CREATE OR REPLACE PROCEDURE GET_EMP
		 * (VEMPNO IN EMP.EMPNO%TYPE,
		 * VENAME OUT EMP.ENAME%TYPE,
		 * VSAL OUT EMP.SAL%TYPE)
		 * 
		 * IS
		 * BEGIN
		 * 		SELECT ENAME, SAL
		 * 		INTO 	VENAME, VSAL
		 * 		FROM 	EMP
		 * 		WHERE	EMPNO = VEMPNO;
		 * 
		 * END;
		 * 
		 */
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			//CallableStatement 객체 얻기
			cstmt = conn.prepareCall("{ call GET_EMP(?,?,?) }");
			
			//IN 변수 설정 
			cstmt.setInt(1,7788);
			
			//OUT 변수 설정
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
			//프로시저 실행
			cstmt.execute();
			
			//출력 파라미터 값 얻기
			String ename = cstmt.getString(2);
			int sal = cstmt.getInt(3);
			System.out.println("사원이름\t급여");
			System.out.println("------------------");
			System.out.println(ename +"\t"+ sal);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} finally {
			if (cstmt != null) 
				try {
					cstmt.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
		}
	}
}
