package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample6_Oracle_update {
	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.println("상품코드와 제조사를 입력하세요.");
			return;
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("update goodsinfo set maker = ? where code = ?");)

		{

			/*
			 * arguments 
			 * 10001 HTA
			 * 
			 * update goodsinfo set maker = 'args[1]' where code = 'args[0]' 
			 * 주로 기본키를 사용한 index 로 지정한다.
			 */


			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다. executeUpdate() 의
			 * 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */
			pstmt.setString(1, args[1]);
			pstmt.setString(2, args[0]);
			int rowNum = pstmt.executeUpdate();
			System.out.println(rowNum + "행이 수정되었습니다.");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
