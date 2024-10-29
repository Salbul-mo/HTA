package net.comment.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.google.gson.*;

public class CommentDAO {
	
	private DataSource ds;
	
	public CommentDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	
	// 글 갯수 구하기
	public int getListCount(int comment_board_num) {
		String sql = """
				select count(*)
				from comm
				where comment_board_num = ?
					""";
		
		int result = 0;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, comment_board_num);
			
			try (ResultSet rs = pstmt.executeQuery();) {
				
				while (rs.next()) {
					result = rs.getInt(1);
				}
			
			}
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getListCount() 에러: " + se);
		}
		
		return result;
	}

	// 글 목록 보기
	public JsonArray getCommentList(int comment_board_num, int state) {
		String sql = """
					select comm.*, member.memberfile
					from comm inner join member
				on comm.id = member.id
				where comment_board_num = ?
				order by comment_re_ref %s , comment_re_seq asc
					""".formatted(state == 1 ? "asc" : "desc");
			/*
				select comm.*, member.memberfile
				from comm inner join member
				on comm.id = member.id
				where comment_board_num = ?
				order by comment_re_ref %s , comment_re_seq asc
			 */
		
		JsonArray arr = new JsonArray();
				// 한 페이지 당 10개 씩 목록인 경우 		1  	2 	3 	4 . . . 10 페이지까지 rownum
		
		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
				
				pstmt.setInt(1, comment_board_num);
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						JsonObject j = new JsonObject();
						j.addProperty("num", rs.getInt("num"));
						j.addProperty("id" , rs.getString("id"));
						j.addProperty("content", rs.getString("content"));
						j.addProperty("reg_date", rs.getString("reg_date"));
						// yyyy-mm-dd hh-mm-ss 로 출력된다.
						j.addProperty("comment_re_lev", rs.getInt("comment_re_lev"));
						j.addProperty("comment_re_seq", rs.getInt("comment_re_seq"));
						j.addProperty("comment_re_ref", rs.getInt("comment_re_ref"));
						j.addProperty("memberfile", rs.getString("memberfile"));
						arr.add(j);
					}
				}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getCommentList() 에러 " + se);
		}
		
		return arr;
	}

	public int commentInsert(Comment co) {
		
		int result = 0;
		String insert_sql = """
							insert into comm
							(NUM, ID, 
							CONTENT, REG_DATE, 
							COMMENT_BOARD_NUM, COMMENT_RE_LEV, 
							COMMENT_RE_SEQ, COMMENT_RE_REF)
							values(
							COM_SEQ.NEXTVAL, ?, 
							?, SYSDATE,
							?,?,
							?,COM_SEQ.NEXTVAL)
							""";
		
		try( Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insert_sql);) {
			
			// 새로운 글 등록
			pstmt.setString(1, co.getId());
			pstmt.setString(2, co.getContent());
			pstmt.setInt(3, co.getComment_board_num());
			pstmt.setInt(4, co.getComment_re_lev());
			pstmt.setInt(5, co.getComment_re_seq());
			
			result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("데이터 삽입이 모두 완료되었습니다.");
				return result;
			} 
		} catch (SQLException se) {
			System.out.println("commentInsert() 에러 " + se);
			se.printStackTrace();
		}
		return result;
	}

	public int commentUpdate(Comment co) {
		
		String modify_sql = """
				update comm
				set content=?
				where num=?
				""";
		
		int result = 0;
			
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(modify_sql);) {
			
			pstmt.setString(1, co.getContent());
			pstmt.setInt(2, co.getNum());

			result = pstmt.executeUpdate();


			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("commentUpdate() 에러 " + se);
			}
		
		return result;
	}

	/*
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

	public Comment getDetail(int board_num) {
		String detail_sql = """
							select * 
							from board 
							where BOARD_NUM=?
							""";
		
		Comment b = null; // 오류 체크를 위해 일단 null 설정
		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(detail_sql);){
			pstmt.setInt(1, board_num);
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					b = new Comment();
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

	public boolean boardModify(Comment boardData) {
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

	private int reply_insert(Connection conn, Comment boardData) throws SQLException {
		
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
	
	public int boardReply(Comment boardData) {
		
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
		
		Comment deletData = null;
		
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
						deletData = new Comment();
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

*/
}
