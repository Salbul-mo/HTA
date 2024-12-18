package net.board.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

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
			System.out.println("getBoardList() 에러 " + se);
		}
		
		return list;
	}

	public boolean boardInsert(BoardBean boardData) {
		
		int result = 0;
		
		String max_sql = "(select nvl(max(board_num),0) +1 from board)";
		
		// 원문 글은 Board_re_ref 필드가 자신의 글 번호이다.
		// %1$s : 첫 번째 인자를 문자열로 출력.
		
		String insert_sql = """
							insert into board
							(BOARD_NUM, BOARD_NAME, 
							BOARD_PASS, BOARD_SUBJECT, 
							BOARD_CONTENT, BOARD_FILE, 
							BOARD_RE_REF, BOARD_RE_LEV,
							BOARD_RE_SEQ, BOARD_READCOUNT)
							values(%1$s,?,
							?,?,
							?,?,
							%1$s,?,
							?,?)
							""".formatted(max_sql);
		
		try( Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insert_sql);) {
			
			// 새로운 글 등록
			pstmt.setString(1, boardData.getBoard_name());
			pstmt.setString(2, boardData.getBoard_pass());
			pstmt.setString(3, boardData.getBoard_subject());
			pstmt.setString(4, boardData.getBoard_content());
			pstmt.setString(5, boardData.getBoard_file());
			pstmt.setInt(6, 0); // lev
			pstmt.setInt(7, 0); // seq
			pstmt.setInt(8, 0); // readcount
			
			
			result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("데이터 삽입이 모두 완료되었습니다.");
				return true;
			} 
		} catch (SQLException se) {
			System.out.println("boardInsert() 에러 " + se);
			se.printStackTrace();
		}
		return false;
	}

	public boolean setReadCountUpdate(int board_num) {
		String readCount_sql = """
								update board
								set BOARD_READCOUNT = BOARD_READCOUNT + 1
								where BOARD_NUM=?
								""";
		boolean is_success = false;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(readCount_sql);) {
			pstmt.setInt(1, board_num);
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) 
				is_success = true;
			
		} catch (SQLException se) {
			System.out.println("setReadCountUpdate() 에러 " + se);
			se.printStackTrace();
		}
		
		return is_success;
	}

	public BoardBean getDetail(int board_num) {
		String detail_sql = """
							select * 
							from board 
							where BOARD_NUM=?
							""";
		
		BoardBean b = null; // 오류 체크를 위해 일단 null 설정
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(detail_sql);){
			pstmt.setInt(1, board_num);
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					b = new BoardBean();
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
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getDetail() 에러 " + se);
		}
		
		return b;
	}

	public boolean isBoardWriter(int num, String pass) {
		
		String check_sql = """
							select board_pass
							from board
							where board_num=?
							""";
		boolean result = false;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(check_sql);) {
			
			pstmt.setInt(1,num);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					if (pass.equals(rs.getString("board_pass"))) {
						result = true;
					}
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("isBoardWriter() 에러 " + se);
		}
		
		return result;
	}

	public boolean boardModify(BoardBean boardData) {
		String modify_sql = """
							update board
							set board_subject=?, board_content=?, board_file=?
							where board_num=?
							""";
		boolean is_success = false;
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(modify_sql);) {
			
			pstmt.setString(1, boardData.getBoard_subject());
			pstmt.setString(2, boardData.getBoard_content());
			pstmt.setString(3, boardData.getBoard_file());
			pstmt.setInt(4, boardData.getBoard_num());
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				is_success = true;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("boardModify() 에러 " + se);
		}
			
		return is_success;
	}

	public void setSeqUpdate(Connection conn, int board_re_ref, int board_re_seq) throws SQLException {
		String seq_update_sql = """
								update board
								set BOARD_RE_SEQ = BOARD_RE_SEQ + 1
								where BOARD_RE_REF=? and BOARD_RE_SEQ > ?
								""";
		
		try (PreparedStatement pstmt = conn.prepareStatement(seq_update_sql); ){
			
			pstmt.setInt(1, board_re_ref);
			pstmt.setInt(2, board_re_seq);
			pstmt.executeUpdate();
		}
	}

	private int reply_insert(Connection conn, BoardBean boardData) throws SQLException {
		
		String max_sql = "(select nvl(max(board_num),0) +1 from board)";
		int num = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(max_sql);) {
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					num = rs.getInt(1);
				}
			}
		}
		
		
		String reply_insert_sql = """
				insert into board
				(BOARD_NUM, BOARD_NAME, 
						BOARD_PASS, BOARD_SUBJECT, 
						BOARD_CONTENT, BOARD_FILE,
						BOARD_RE_REF, BOARD_RE_LEV, 
						BOARD_RE_SEQ, BOARD_READCOUNT)
				values (?,?,?,?,?,?,?,?,?,?)
				""";
		
		try (PreparedStatement pstmt = conn.prepareStatement(reply_insert_sql);) {
			pstmt.setInt(1, num);
			pstmt.setString(2, boardData.getBoard_name());
			pstmt.setString(3, boardData.getBoard_pass());
			pstmt.setString(4, boardData.getBoard_subject());
			pstmt.setString(5, boardData.getBoard_content());
			pstmt.setString(6, "");
			pstmt.setInt(7, boardData.getBoard_re_ref()); // 원본 글 번호
			pstmt.setInt(8, boardData.getBoard_re_lev() +1); // lev + 1
			pstmt.setInt(9, boardData.getBoard_re_seq() +1); // seq + 1
			pstmt.setInt(10, 0);
			
			pstmt.executeUpdate();
		}
		
		return num; // 답변 board_num 반환
	}
	
	public int boardReply(BoardBean boardData) {
		
		int result = 0;
		
		try(Connection conn = ds.getConnection();) {
			
			conn.setAutoCommit(false);
			
			try {
				setSeqUpdate(conn, boardData.getBoard_re_ref(), boardData.getBoard_re_seq());
				result = reply_insert(conn, boardData);
				conn.commit();
				
			} catch (SQLException se) {
				se.printStackTrace();
				
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException se2) {
						se2.printStackTrace();
					}
				}
			}
			
			conn.setAutoCommit(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("boardReply() 에러 : " + ex);
		}
		
		return result;
	}

	public boolean boardDelete(int num) {
		
		BoardBean deletData = null;
		
		String get_sql = """
					select board_re_ref, board_re_lev, board_re_seq
					from board
					where board_num =?
								""";
		
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(get_sql);) {
					
			pstmt.setInt(1, num);
					
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						deletData = new BoardBean();
						deletData.setBoard_re_ref(rs.getInt(1));
						deletData.setBoard_re_lev(rs.getInt(2));
						deletData.setBoard_re_seq(rs.getInt(3));
					}
				}
					
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("삭제 정보 조회 실패 " + se);
			}
		
		if (deletData == null) {
			return false;
		}
		
		boolean is_success = false;
		
		String delete_sql = """
							delete board
							where BOARD_RE_REF = ?
							and BOARD_RE_LEV >= ?
							and BOARD_RE_SEQ >= ?
							and BOARD_RE_SEQ <= (
												 nvl((select min(BOARD_RE_SEQ) -1 
												 from board
												 where BOARD_RE_REF = ?
												 and BOARD_RE_LEV = ?
								 				 and BOARD_RE_SEQ > ? )
												 ,
												 (select max(BOARD_RE_SEQ) 
							 					 from board 
									 			 where BOARD_RE_REF = ?))
									 			 )
							""";
		// 같은 레벨의 글 중 자신보다 큰 seq 의 최소값에서 1을 빼면 자기에게 달린 글의 seq 중 최대값이 된다.
		// 없으면 같은 ref 중 가장 큰 seq 값으로 한다.
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(delete_sql);) {
			
			pstmt.setInt(1, deletData.getBoard_re_ref());
			pstmt.setInt(2, deletData.getBoard_re_lev());
			pstmt.setInt(3, deletData.getBoard_re_seq());
			pstmt.setInt(4, deletData.getBoard_re_ref());
			pstmt.setInt(5, deletData.getBoard_re_lev());
			pstmt.setInt(6, deletData.getBoard_re_seq());
			pstmt.setInt(7, deletData.getBoard_re_ref());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				is_success = true;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("삭제에 실패했습니다." + se);
		}
		
		return is_success;
	}

}
