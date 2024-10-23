package net.board.db;

import java.net.http.HttpResponse.PushPromiseHandler;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.google.gson.*;

public class BoardDAO {
	
	private DataSource ds;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	
	// 글 갯수 구하기
	public int getListCount() {
		String sql = """
					select count(*) from board
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
		}
		
		return result;
	}

	// 글 목록 보기
	public List<BoardBean> getBoardList(int page, int limit) {
		/*
			page : 현재 페이지
			limit : 페이지 당 출력 목록 수
			board_re_ref desc, board_re_seq asc 에 의해 정렬한 것을
			rownum 으로 잘라오는 쿼리문
		 */
		
		String sql = """
				  	select *
					from (select rownum as rnum, j.*
							from (select board.*, nvl(cnt,0) as cnt
									from board left outer join (select comment_board_num, count(*) as cnt
																from comm
																group by comment_board_num)
									on board_num = comment_board_num
									order by board_re_ref desc, board_re_seq asc) j
							where rownum <= ? )
					where rnum >= ? and rnum <= ?																																											
					""";
		List<BoardBean> list = new ArrayList<>();
				// 한 페이지 당 10개 씩 목록인 경우 		1  	2 	3 	4 . . . 10 페이지까지 rownum
		int startRow = (page - 1) * limit + 1; //	1	11	21	31 . . 	91	
		int endRow = startRow + limit - 1;	//		10	20	30	40	. . 100
		
		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
				pstmt.setInt(1,endRow);
				pstmt.setInt(2,startRow);
				pstmt.setInt(3,endRow);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						BoardBean b = new BoardBean();
						b.setBoard_num(rs.getInt("BOARD_NUM"));
						b.setBoard_name(rs.getString("BOARD_NAME"));
						b.setBoard_subject(rs.getString("BOARD_SUBJECT"));
						b.setBoard_content(rs.getString("BOARD_CONTENT"));
						b.setBoard_file(rs.getString("BOARD_FILE"));
						b.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
						b.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
						b.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
						b.setBoard_readCount(rs.getInt("BOARD_READCOUNT"));
						b.setBoard_date(rs.getString("BOARD_DATE"));
						b.setCnt(rs.getInt("cnt"));
						list.add(b);
					}
				}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getBoardList() 에러 : " + se);
		}
		
		return list;
	}

}
