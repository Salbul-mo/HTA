package net.member.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.google.gson.*;

public class MemberDAO {
	
private DataSource ds;
	
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	
	public int isId(String id) {
		String password = null;
		return isId(id, password);
	}

	public int isId(String id, String password) {
		int result = 0; // 아이디가 존재하지 않는 경우
		String select_sql = """
							select id, password
							from member
							where id=?
							""";
		
		try (Connection conn = ds.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(select_sql);) {
			
			pstmt.setString(1, id);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				
				if (rs.next()) { // db 에서 id 가 조회됐으면 1 또는 -1, 조회 결과가 없으면 0  
					
					if (rs.getString("password").equals(password)) {
						result = 1; // 아이디와 비밀번호가 일치하는 경우
					} else { 
						result = -1; // 아이디는 일치하고 비밀번호가 일치하지 않는 경우
					}
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}

	public int insert(Member m) {
		int result = 0;
		String insert_sql = """
							insert into member
							(id, password, name, age, gender, email)
							values (?,?,?,?,?,?)
							""";
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insert_sql);) {
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		
		String delete_sql = """
							delete from member
							where id=?
							""";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete_sql);) {
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		return result;
		
	}
	
	public Member getMember(String id) {
		
		String member_sql = """
							select * 
							from member
							where id=?
							""";
		Member mem = null;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(member_sql);) {
			
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				
				if(rs.next()) {
					mem = new Member();
					
					mem.setId(rs.getString("id"));
					mem.setPassword(rs.getString("password"));
					mem.setName(rs.getString("name"));
					mem.setAge(rs.getInt("age"));
					mem.setGender(rs.getString("gender"));
					mem.setEmail(rs.getString("email"));
					mem.setMemberfile(rs.getString("memberfile"));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getMember() 에러 " + se);
		}
		return mem;
	}

	public boolean updateMember(Member mem) {

		String update_sql = """	
							update member
							set name=?, age=?, email=?, memberfile=?
							where id=?
							""";
		boolean is_success = false;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(update_sql);) {
			
			pstmt.setString(1, mem.getName());
			pstmt.setInt(2, mem.getAge());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getMemberfile());
			pstmt.setString(5, mem.getId());
			
			if (pstmt.executeUpdate() > 0) {
				is_success = true;
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("updateMember() 에러" + se);
		}
		
		return is_success;
	}
}
