package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample5_Oracle_delete {

	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("상품코드를 입력하세요.");
			return;
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("delete from goodsinfo where code = ?");)

		{

			/*
			 * arguments A5000
			 * 
			 */
			

			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다. 
			 * executeUpdate() 의 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */
			pstmt.setString(1, args[0]);
			int rowNum = pstmt.executeUpdate();
			System.out.println(rowNum + "행이 삭제되었습니다.");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
