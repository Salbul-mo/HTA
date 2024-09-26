package ex21_2_select_statement;

import java.sql.*;

public class Practice2 {

	public static void main(String args[]) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
		
		//1 JDBC 드라이버 로드
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		//2 DB 연결
		String url = "jdbc:orcle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url,"scott","tiger");
		
		//3 쿼리문 입력
		stmt = conn.createStatement();
		/*
		 * Statement java.sql.Connection.createStatement() throws SQLException
		 * 
		 * Creates a Statement object for sending SQL statements to the database.
		 * SQL statements without parameters are normally executed using Statement objects. 
		 * If the same SQL statement is executed many times, it may be more efficient to use a PreparedStatement object. 
		 * Result sets created using the returned Statement object will by default be type TYPE_FORWARD_ONLY and
		 * have a concurrency level of CONCUR_READ_ONLY. 
		 * The hold ability of the created result sets can be determined by calling getHoldability.
		 * 
		 * Returns: a new default Statement object
		 * Throws: SQLException - if a database access error occurs or this method is called on a closed connection
		 *
		 */
		String select_sql = "select * from dept";
		
		rs = stmt.executeQuery(select_sql);
		
		int i = 0;
		
		while(rs.next()) {
			int deptno = rs.getInt("deptno");
			
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
