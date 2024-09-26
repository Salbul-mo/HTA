package ex21_2_select_statement;

import java.sql.*;

public class Practice {

	public static void main(String[] args) {

		Connection conn = null;
		
		try {
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver); //jdbc OracleDriver 클래스 실행
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"scott","tiger");
			
			System.out.println("데이터베이스에 접속했습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			if (conn != null)
				try {
					conn.close(); 
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
		
	}
}
