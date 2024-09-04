package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample2_Oracle_column_name_dept {

	public static void main(String args[]) {
		/*
		 * PreparedStatment 사용하기
		 * Statement 와 달리 PreparedStatement 객체를 생성할 때 
		 * sql 문의 기본틀을 미리 입력해야 한다.
		 * 즉, 틀을 미리 생성해 놓고 값을 나중에 지정한다.
		 * PreparedStatement pstmt = conn.preparedStatement(sql);
		 * 실행 전에 ? (위치홀더 - placeholder)가 값으로 바뀌어 입력된다.
		 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				PreparedStatement pstmt = conn.prepareStatement("select * from dept");
				ResultSet rs = pstmt.executeQuery();)
		{
			
			System.out.println("번호\t부서번호\t부서명\t\t지역");
			System.out.println("--------------------------------------------------------------");
			int i = 0;
			
			while (rs.next()) {
				System.out.printf("%d\t%d\t%-10s\t%s\n", ++i, rs.getInt(1), rs.getString(2), rs.getString(3));

			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
