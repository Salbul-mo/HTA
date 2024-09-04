package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample2_Oracle1_column_name_emp {

	public static void main(String args[]) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("select * from emp");
				ResultSet rs = pstmt.executeQuery();) {
			int i = 0;

			System.out.println("번호\t사원번호\t사원이름\t직급\t\t상사\t입사일\t\t급여\t커미션\t부서번호");
			System.out.println("----------------------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%d\t%d\t%s\t%-10s\t%d\t%s\t%d\t%d\t%d\n", ++i, rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5).substring(0, 11), rs.getInt(6), rs.getInt(7),
						rs.getInt(8));
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
