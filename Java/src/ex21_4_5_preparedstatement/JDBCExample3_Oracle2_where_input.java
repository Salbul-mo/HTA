package ex21_4_5_preparedstatement;

import java.sql.*;
// run as arguments 탭에 "디지털  TV" 라고 입력하고
// 데이터 베이스의 테이블로부터 조건에 맞는 데이터를 입력받아 출력하는 예제
public class JDBCExample3_Oracle2_where_input {

	public static void main(String args[]) throws Exception {
		if (args.length != 1 ) {
			System.out.println("상품명을 입력하세요");
			return;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");

			String select_sql = "select * from goodsinfo where name = ? ";
			pstmt = conn.prepareStatement(select_sql);

			pstmt.setString(1,args[0]);
			rs = pstmt.executeQuery();

			System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
			System.out.println("----------------------------------------------");


			int i = 0;

			while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복, 읽어들인 데이터가 없으면 false 리턴
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");

				System.out.printf("%d\t%5d\t%-12s\t%-8d%s\n", ++i, code, name, price, maker);

			}
		} catch (ClassNotFoundException cnfe) { // OracleDriver 기동시킬 때 클래스가 없으면 일어나는 오류 예외처리
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) { // getConnection, createStatement, executeQuery 가 일으키는 오류 예외처리
			System.out.println(se.getMessage());
		} finally { // 닫을 때는 역순으로
			if (rs != null)
				try {
					rs.close(); // ResultSet 닫기
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			if (pstmt != null)
				try {
					pstmt.close(); // Statement 닫기
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
