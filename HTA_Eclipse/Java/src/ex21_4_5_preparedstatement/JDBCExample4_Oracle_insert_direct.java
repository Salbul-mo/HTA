package ex21_4_5_preparedstatement;

//데이터 베이스의 테이블에 데이터를 추가하는 프로그램
//executeUpdate 메서드 사용

import java.sql.*;

public class JDBCExample4_Oracle_insert_direct {

	public static void main(String args[]) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			pstmt = conn.prepareStatement("insert into goodsinfo values(?,?,?,?)");

			// values('A1000','고급 핸드폰', 100, 'LG')
			// placeHolder 에 차례대로 값을 넣는다.

			pstmt.setString(1, "A5000");
			pstmt.setString(2, "키보드");
			pstmt.setInt(3, 300);
			pstmt.setString(4, "손의나라");

			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다. executeUpdate() 의
			 * 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */

			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 추가되었습니다.");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();

				} catch (SQLException se) {
					System.out.println(se.getMessage());
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException se) {
					System.out.println(se.getMessage());
				}
		}
	}
}
