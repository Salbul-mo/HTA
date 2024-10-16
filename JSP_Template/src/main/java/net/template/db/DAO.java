package net.template.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

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
	
	// 메서드 오버로딩, 비밀번호 없이 메서드 호출 됐을 때 password 에 null 넣고 isId 호출
	public int isId(String id) {
		return isId(id, null);
	}
	
	public int isId(String id, String password) {
		int result = 0; // 아이디가 존재하지 않는 경우
		String select_sql = """
							select id, password
							from template_join
							where id=?
							""";
		
		try (Connection conn = ds.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(select_sql);) {
			
			pstmt.setString(1, id);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				
				if (rs.next()) { // db 에서 id 가 조회됐으면 1 또는 -1, 조회 결과가 없으면 0  
								 // ORA-00942: table or view does not exist 
								 // => 예외 StackTrace 출력하고 try 빠져나간다.
					if (rs.getString("password").equals(password)) 
						result = 1; // 아이디와 비밀번호가 일치하는 경우
					else 
						result = -1; // 아이디는 일치하고 비밀번호가 일치하지 않는 경우
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return result;
	}

	public int insert(TemplateJoin templateJoin) {
		
		String insert_sql = """
							insert into template_join (id, password, jumin, email, gender, hobby, post, address, intro)
							values (?,?,?,?,?,?,?,?,?)
							""";
							// jdbc 이용해서 sql 문 작성할 때 세미콜론 주의해야 한다.
		int result = 0;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insert_sql);) {
			
			pstmt.setString(1, templateJoin.getId());
			pstmt.setString(2, templateJoin.getPassword());
			pstmt.setString(3, templateJoin.getJumin());
			pstmt.setString(4, templateJoin.getEmail());
			pstmt.setString(5, templateJoin.getGender());
			pstmt.setString(6, templateJoin.getHobby());
			pstmt.setString(7, templateJoin.getPost());
			pstmt.setString(8, templateJoin.getAddress());
			pstmt.setString(9, templateJoin.getIntro());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 추가되었습니다.");
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<TemplateJoin> selectAll() {
		
		ArrayList<TemplateJoin> list = new ArrayList<>();
		
		// admin 계정은 제외
		String sql_selectAll = """
								select * from Template_join
								where id != 'admin'
								order by register_date desc
							   """;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql_selectAll);
				ResultSet rs = pstmt.executeQuery(); ){
			
			while (rs.next()) {
				TemplateJoin temp = new TemplateJoin();
				
				temp.setId(rs.getString("id"));
				temp.setGender(rs.getString("gender"));
				temp.setHobby(rs.getString("hobby"));
				temp.setIntro(rs.getString("intro"));
				temp.setRegister_date(rs.getString("register_date").substring(0,11));
				//temp.setPassword(rs.getString("password"));
				//temp.setEmail(rs.getString("email"));
				//temp.setAddress(rs.getString("address"));
				//temp.setJumin(rs.getString("jumin"));
				//temp.setPost(rs.getString("post"));
				list.add(temp);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return list;
	}	

}
