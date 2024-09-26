package ex21_4_5_preparedstatement;

import java.sql.*;

public class JDBCExample2_Oracle1_where_goodsinfo_try_resource {

	public static void main(String args[]) throws Exception {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("select * from goodsinfo where name = ? ");	
			) 
		
		{
			pstmt.setString(1, "디지털  TV");
			
			try (ResultSet rs = pstmt.executeQuery();) 
				{
				
					int i = 0;
					System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
					System.out.println("--------------------------------------------------");
					
					while (rs.next()) {
						System.out.printf("%d\t%s\t%s\t%d\t%s\n", ++i, rs.getString(1), rs.getString(2), rs.getInt(3),
								rs.getString(4));
	
					}

				}
			
		} catch (SQLException se) {
				System.out.println(se.getMessage());
		}

	}
}

