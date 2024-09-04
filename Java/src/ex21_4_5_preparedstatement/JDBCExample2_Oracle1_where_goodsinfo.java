package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample2_Oracle1_where_goodsinfo {

	public static void main(String args[]) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			String select_sql = "select * from goodsinfo where name = ?";


			pstmt = conn.prepareStatement(select_sql);

			// placeHolder 자리에 값 입력
			pstmt.setString(1, "디지털  TV");
			//이 문장 빼먹으면 나오는 오류 문구 
			//인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
			rs = pstmt.executeQuery();

			System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
			System.out.println("----------------------------------------------");


			int i = 0;

			while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복, 읽어들인 데이터가 없으면 false 리턴
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");

				System.out.printf("%d\t%5s\t%-12s\t%-8d%s\n", ++i, code, name, price, maker);

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
