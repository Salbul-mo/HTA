package ex23_board;

import java.sql.*;
import java.util.*;

public class BoardDAO_seq {

	public int boardInsert(Board board) { // 원문 글 추가
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into board " + " (board_num, board_name, board_pass, board_subject, board_content,"
								+ " board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date) "
								+ " values (board_seq.nextval, ?, ?, ?, ?, board_seq.nextval, 0, 0, 0, sysdate)");) {

			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());

			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}

		return 0;
	}

	public int boardReply(Board board) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into board " + " (board_num, board_name, board_pass, board_subject, board_content, "
								+ " board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date) "
								+ " values (board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 0, sysdate)");) {

			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setInt(5, board.getBoard_re_ref());
			pstmt.setInt(6, board.getBoard_re_lev());
			pstmt.setInt(7, board.getBoard_re_seq());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}

		return 0;
	}

	public List<Board> getBoardList(int page, int limit) {
		List<Board> list = new ArrayList<Board>();
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(
						"select board_num, board_name, board_subject, board_content, board_re_ref, board_re_lev, board_re_seq, board_date "
								+ " from ( select rownum as rnum, b.*" 
											+ "	from (select * from board"
													+ "	order by board_re_ref desc, board_re_seq asc) b"
										+ " where rownum <= ? )"
						+ " where rnum between ? and ? ");) {
			
			pstmt.setInt(1, page * limit); // endrow
			pstmt.setInt(2, (page-1) * limit + 1); // startrow
			pstmt.setInt(3, page * limit);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				
				while (rs.next()) {
					
					Board board = new Board();
					board.setBoard_num(rs.getInt(1));
					board.setBoard_name(rs.getString(2));
					board.setBoard_subject(rs.getString(3));
					board.setBoard_content(rs.getString(4));
					board.setBoard_re_ref(rs.getInt(5));
					board.setBoard_re_lev(rs.getInt(6));
					board.setBoard_re_seq(rs.getInt(7));
					board.setBoard_date(rs.getString(8)); // 날짜 데이터 시 분 초까지 문자열로 가져온다.

					list.add(board);
				}
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return list;
	}

}
