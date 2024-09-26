package ex21_4_4_preparedstatement;

import java.sql.*;

public class JDBCExample_different_insert1_Statement {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}

		int result = 0;
		int count = 0;

		long start = System.currentTimeMillis();

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();) {
			for (int i = 0; i < 10000; i++) {
				String sql = "insert into test(no,name) " + "values(" + i + ", '홍길동' )";
				result = stmt.executeUpdate(sql);
				count += result;
			}

			long end = System.currentTimeMillis();

			System.out.println("소요시간: " + (end - start) + "ms");

			if (count == 10000)
				System.out.println("삽입 완료");
			/*
			 * 소요시간: 6546ms
			 * 삽입 완료
			 */

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

}
