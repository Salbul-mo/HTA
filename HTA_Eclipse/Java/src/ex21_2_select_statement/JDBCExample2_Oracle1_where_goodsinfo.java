package ex21_2_select_statement;

import java.sql.*;

public class JDBCExample2_Oracle1_where_goodsinfo {

	public static void main(String args[]) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1단계 : JDBC 드라이버를 로드한다.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			// 2단계 : DB에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");

			/*
			 * 데이터 베이스에 있는 테이블의 데이터를 읽어오기 위해 Statement 객체가 필요하다 2단계에서 얻은 Connection 객체에 대해
			 * createStatement 메서드를 호출해서 얻는다
			 * 
			 */

			stmt = conn.createStatement();

			/*
			 * Statement 타입은 java.sql 패키지에 속하는 인터페이스 이름으로 select 문을 실행하는 executeQuery 라는
			 * 메서드가 있다. 이 메서드는 파라미터로 select 문을 넘겨주어야 한다. 이 메서드는 파라미터로 넘겨준 select 문을 데이터 베이스로
			 * 보내서 실행하고 그 결과로 ResultSet 객체를 리턴한다.
			 * 
			 */

			String select_sql = "select * from goodsinfo where name = '디지털  TV'";
			// select 문 문자열

			rs = stmt.executeQuery(select_sql);
			// select 문 실행. 결과 데이터 ResultSet rs 에 대입

			System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
			System.out.println("----------------------------------------------");

			/*
			 * ResultSet 객체로부터 select문의 실행 결과를 얻기 위해서는 먼저 next() 메서드를 호출해야한다. re.next() - 다음
			 * 행 위치로 이동하는 메서드 리턴값은 boolean 으로 실제로 행을 읽어 왔는지 여부이다.
			 */

			int i = 0;

			while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복, 읽어들인 데이터가 없으면 false 리턴
				/*
				 * boolean java.sql.ResultSet.next() throws SQLException
				 * 
				 * 
				 * Moves the cursor forward one row from its current position.
				 * A ResultSet cursor is initially positioned before the first row; 
				 * the first call to the method next makes the first row the current row;
				 * the second call makes the second row the current row, and so on.
				 * 
				 * When a call to the next method returns false,
				 * the cursor is positioned after the last row. 
				 * Any invocation of a ResultSet method which requires a current row 
				 * will result in a SQLException being thrown.
				 * If the result set type is TYPE_FORWARD_ONLY, 
				 * it is vendor specified whether their JDBC driver implementation will return false or
				 * throw an SQLException on a subsequent call to next.
				 * 
				 * If an input stream is open for the current row, a call to the method next
				 * willimplicitly close it. A ResultSet object'swarning chain is cleared when a
				 * new row is read. Returns:true if the new current row is valid; false if there
				 * are no more rowsThrows:SQLException - if a database access error occurs or
				 * this method iscalled on a closed result set
				 */
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");

				System.out.printf("%d\t%5d\t%-12s\t%-8d%s\n", ++i, code, name, price, maker);

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally { // 닫을 때는 역순으로
			if (rs != null)
				try {
					rs.close(); // ResultSet 닫기
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			if (stmt != null)
				try {
					stmt.close(); // Statement 닫기
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (conn != null)
				try {
					conn.close(); // Connection 닫기
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
