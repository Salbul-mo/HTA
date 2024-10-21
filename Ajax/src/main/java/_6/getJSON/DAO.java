package _6.getJSON;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.google.gson.*;

public class DAO {
	
	private DataSource ds;
	
	public DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	
	public JsonArray getList_lib() {
		
		JsonArray arr = new JsonArray();
		
		String sql = 	"""
						select * from dept
						""";
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			while (rs.next()) {
				JsonObject json = new JsonObject();
				
				json.addProperty("deptno", rs.getInt("deptno"));
				json.addProperty("dname", rs.getString("dname"));
				json.addProperty("loc", rs.getString("loc"));
				arr.add(json);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return arr;
		
	}

	public JsonArray getList_lib_search(int deptno) {
		
		JsonArray arr = new JsonArray();
		
		String sql = 	"""
						select * from dept
						where deptno=?
						""";
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, deptno);
			
			try (ResultSet rs = pstmt.executeQuery();){
			
			
				while (rs.next()) {
					JsonObject json = new JsonObject();
				
					json.addProperty("deptno", rs.getInt("deptno"));
					json.addProperty("dname", rs.getString("dname"));
					json.addProperty("loc", rs.getString("loc"));
					
					arr.add(json);
				}
			
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return arr;
		
	}

}
