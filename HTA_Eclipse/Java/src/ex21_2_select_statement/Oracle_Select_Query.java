package ex21_2_select_statement;

import java.sql.*;

public class Oracle_Select_Query {

	public static void main(String args[]) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		}
		/*
		 * try/catch for Class.forName("org.apache.hive.jdbc.HiveDriver"); - because
		 * this is not AutoCloseable try-with-ressource for Connection con =
		 * DriverManager.getConnection(connectionUri, userName, password); Statement
		 * stmt = con.createStatement();- because Connection and Statement implement
		 * AutoCloseable
		 */

		try (
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("");
			) 
		{
			int i = 0;
			while (rs.next()) {
				// rs.getType 메서드
				System.out.printf("%d", i);
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}
}
