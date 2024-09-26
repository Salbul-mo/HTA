package ex21_1_connect_test;

import java.sql.*;

public class ConnectionPractice {

	public static void main(String args[]) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스가 없습니다.");
			cnfe.getStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("sql");)
		{
			while(rs.next()) {
				System.out.println(rs.getObject(0));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
