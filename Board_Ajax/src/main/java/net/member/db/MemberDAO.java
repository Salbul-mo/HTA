package net.member.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import net.member.db.*;
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

	public int getListCount() {
		String sql = """
					select count(*) from member
					where id != 'admin'
					""";
		int result = 0;
			
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
				
			while (rs.next()) {
				result = rs.getInt(1);
			}
				
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getListCount() 에러: " + se);
		}
			
		return result;
	}

	public List<Member> getMemberList(int page, int limit) {
			/*
				page : 현재 페이지
				limit : 페이지 당 출력 목록 수
				board_re_ref desc, board_re_seq asc 에 의해 정렬한 것을
				rownum 으로 잘라오는 쿼리문
			 */
			String sql = """
					  	select *
						from (select rownum as rnum, j.*
								from (select *
										from member
										where id != 'admin'
										order by id) j
								where rownum <= ? )
						where rnum >= ? and rnum <= ?																																											
						""";
			List<Member> list = new ArrayList<>();
			
			try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				// 한 페이지 당 10개 씩 목록인 경우 		1  	2 	3 	4 . . . 10 페이지까지 rownum
				int startRow = (page - 1) * limit + 1; //	1	11	21	31 . . 	91	
				int endRow = startRow + limit - 1;	//		10	20	30	40	. . 100
				
					pstmt.setInt(1,endRow);
					pstmt.setInt(2,startRow);
					pstmt.setInt(3,endRow);
					
					try (ResultSet rs = pstmt.executeQuery();) {
						
						while (rs.next()) {
							Member m = new Member();
							m.setId(rs.getString("id"));
							m.setPassword(rs.getString("password"));
							m.setName(rs.getString("name"));
							m.setAge(rs.getInt("age"));
							m.setGender(rs.getString("gender"));
							m.setEmail(rs.getString("email"));
							list.add(m);
						}
					}
				
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("getMemberList() 에러 " + se);
			}
			
			return list;
		}

	public int getListCount(String string, String search_word) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<net.member.db.Member> getMemberList(String string, String search_word, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	}
