package ex21_3_insert_delete_update;

//데이터 베이스의 테이블에 데이터를 추가하는 프로그램
//executeUpdate 메서드 사용

import java.sql.*;

public class JDBCExapmle4_Oracle_insert_direct {

	public static void main(String args[]) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				Statement stmt = conn.createStatement();)
		
		{	
			/*
			 * 1. 직접 데이터를 입력하는 경우
			 * 		insert into goodsinfo
			 * 		values('A1000','고급 핸드폰', 100, 'LG')
			 */
			
			String sql = "insert into goodsinfo values('A1000','고급 핸드폰',100,'LG')";
			
			System.out.println(sql);
			
			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다.
			 * executeUpdate() 의 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */
			
			int rowNum =stmt.executeUpdate(sql);
			System.out.println(rowNum + "행이 추가되었습니다.");
			
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
