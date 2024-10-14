package ex8;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.naming.*;

public class DAO {
	private DataSource ds;

	// 생성자에서 JNDI 리소스를 참조하여 Connection 객체를 가져올 수 있는 DataSource 를 구한다.

	public DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}

	public ArrayList<Dept> selectAll() {
		
		ArrayList<Dept> list = new ArrayList<>();
		
		try (Connection conn = ds.getConnection();
			 PreparedStatement psmt = conn.prepareStatement("select * from dept");
			 ResultSet rs = psmt.executeQuery();) 
		{
			System.out.println("DB에 연결 되었습니다.");
			
			while (rs.next()) {

				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				list.add(dept);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	return list; // null 을 넘기면 나중에 NullPointException 발생
}

}
