package ex21_4_5_preparedstatement;

import java.sql.*;
import java.util.*;

//Scanner 를 사용하여 키보드로 직접 출력할 데이터 지정하는 예제
// 데이터 베이스의 테이블로부터 조건에 맞는 데이터를 입력받아 출력하는 예제
public class JDBCExample3_Oracle2_where_input_Scanner_try_resource {

	public static void main(String args[]) throws Exception {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (Scanner sc = new Scanner(System.in);
			 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			 PreparedStatement pstmt = conn.prepareStatement("select * from goodsinfo where name = ?");
			) 
		{

			System.out.print("검색어를 입력하세요>");
			pstmt.setString(1, sc.nextLine().trim());

			try (ResultSet rs = pstmt.executeQuery();) {

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
			}

		} catch (SQLException se) { // getConnection, createStatement, executeQuery 가 일으키는 오류 예외처리
			System.out.println(se.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
