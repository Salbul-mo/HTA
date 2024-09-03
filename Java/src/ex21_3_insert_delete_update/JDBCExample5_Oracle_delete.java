package ex21_3_insert_delete_update;

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
				Statement stmt = conn.createStatement();)

		{

			/*
			 * arguments A2000
			 * 
			 * delete from goodsinfo where code = 'args[0]' 주로 기본키를 사용한 index 로 지정한다.
			 */
			
			String single = "'";
			String sql = "delete from goodsinfo where code = " + single + args[0] + single;
			System.out.println(sql);

			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다. 
			 * executeUpdate() 의 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */

			int rowNum = stmt.executeUpdate(sql);
			System.out.println(rowNum + "행이 삭제되었습니다.");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
