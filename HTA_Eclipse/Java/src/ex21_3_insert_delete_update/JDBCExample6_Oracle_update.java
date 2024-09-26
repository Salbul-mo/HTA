package ex21_3_insert_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
				Statement stmt = conn.createStatement();)

		{

			/*
			 * arguments 
			 * 10004 오라클
			 * 
			 * update goodsinfo set maker = 'args[1]' where code = 'args[0]' 
			 * 주로 기본키를 사용한 index 로 지정한다.
			 */

			String single = "'";
			String sql = "update goodsinfo set maker =" + single + args[1] + single +
					" where code = " + single + args[0] + single;
			System.out.println(sql);

			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다. executeUpdate() 의
			 * 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */

			int rowNum = stmt.executeUpdate(sql);
			System.out.println(rowNum + "행이 수정되었습니다.");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
