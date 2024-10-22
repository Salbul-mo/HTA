package _6.getJSON;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.google.gson.*;

public class DAO_Product {
	
	private DataSource ds;
	
	public DAO_Product() {
		
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결에 실패했습니다.");
			ex.printStackTrace();
		}
	}

	public JsonArray getList() {
		JsonArray arr = new JsonArray(); 
		
		String sql = """
						select * 
						from products
						order by id
					 """;
		
		try (	Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(); ) {
			
			while (rs.next()) {
				JsonObject json = new JsonObject();
				
				json.addProperty("id", rs.getInt("id"));
				json.addProperty("name", rs.getString("name"));
				json.addProperty("price", rs.getInt("price"));
				json.addProperty("maker", rs.getString("maker"));
				
				arr.add(json);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return arr;
	}

	public int insert(DTO product) {
		String sql = """
					insert into products
					values (
					(select nvl(max(id),0) + 1 from products),?,?,?
					)
					""";
		int result = 0;
		
		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getMaker());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
				
		return result;
	}
	
	public int update(DTO product) {
		String sql = """
					update products
					set name=?, price=?, maker=?
					where id=?
					""";
		int result = 0;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getMaker());
			pstmt.setInt(4, product.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}

	public int delete(int id) {
		String sql = """
					delete from products
					where id=?
					""";
		int result = 0;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		
		return result;
	}
	
	
}
