package ex23_board;

import java.sql.*;
import java.util.*;

public class BoardDAO_seq {
	
	public int count() {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			 PreparedStatement pstmt = conn.prepareStatement("select count(*) from board");
			 ResultSet rs = pstmt.executeQuery();) {
			
			if (rs.next())
				return rs.getInt(1);
			
			
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
						  " select * " 
						+ " from ( select rownum as rnum, b.* "
						+ "        from (select board_num, board_name, board_subject, board_content, "
						+ "                  board_re_ref, board_re_lev, board_re_seq, board_date "
						+ "              from board " 
						+ "	             order by board_re_ref desc, board_re_seq asc) b "
						+ "        where rownum <= ? )" 
						+ " where rnum between ? and ? ");) {
			// 서브 쿼리로 가져올 때 처음부터 필요한 정보를 제한해서 가져와야 리소스 소모가 덜하다.

			pstmt.setInt(1, page * limit); // endrow
			pstmt.setInt(2, (page - 1) * limit + 1); // startrow
			pstmt.setInt(3, page * limit);

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {

					Board board = new Board();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_name(rs.getString("board_name"));
					board.setBoard_subject(rs.getString("board_subject"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_re_ref(rs.getInt("board_re_ref"));
					board.setBoard_re_lev(rs.getInt("board_re_lev"));
					board.setBoard_re_seq(rs.getInt("board_re_seq"));
					board.setBoard_date(rs.getString("board_date")); // 날짜 데이터 시 분 초까지 문자열로 가져온다.

					list.add(board);
				}
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return list;
	}
	
	public List<Board> getSearchList(String word) {
		List<Board> list = new ArrayList<Board>();
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			 PreparedStatement pstmt = conn.prepareStatement(
						  " select * " 
						+ " from ( select rownum as rnum, b.* "
						+ "        from (select board_num, board_name, board_subject, board_content, "
						+ "                  board_re_ref, board_re_lev, board_re_seq, board_date "
						+ "              from board "
						+ "              where board_subject like ? or board_content like ? " 
						+ "	             order by board_re_ref desc, board_re_seq asc) b "
						+ "        where rownum <= 10 )" 
						+ " where rnum between 1 and 10 ");) {
			// 일단 검색 결과는 10개로 제한
			
			word = "%"+word+"%";
			// placeHolder 에 문자열 입력하면 sql에서 ''로 감싸져서 입력되는듯 하다.
			
			pstmt.setString(1, word);
			pstmt.setString(2, word);

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {

					Board board = new Board();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_name(rs.getString("board_name"));
					board.setBoard_subject(rs.getString("board_subject"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_re_ref(rs.getInt("board_re_ref"));
					board.setBoard_re_lev(rs.getInt("board_re_lev"));
					board.setBoard_re_seq(rs.getInt("board_re_seq"));
					board.setBoard_date(rs.getString("board_date")); // 날짜 데이터 시 분 초까지 문자열로 가져온다.

					list.add(board);
				}
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return list;
	}
	
	public Board getDetail(int board_num) {

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			 PreparedStatement pstmt = conn.prepareStatement("select * from board where board_num = ? ");) {

			pstmt.setInt(1, board_num);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					Board board = new Board();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_name(rs.getString("board_name"));
					board.setBoard_pass(rs.getString("board_pass"));
					board.setBoard_subject(rs.getString("board_subject"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_re_ref(rs.getInt("board_re_ref"));
					board.setBoard_re_lev(rs.getInt("board_re_lev"));
					board.setBoard_re_seq(rs.getInt("board_re_seq"));
					board.setBoard_readcount(rs.getInt("board_readcount"));
					board.setBoard_date(rs.getString("board_date"));
					// 가급적 컬럼 이름과 필드 이름을 일치시켜서 혼동이 없도록 한다.

					return board;
				}
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return null;
	}

	public int boardInsert(Board board) { // 원문 글 추가
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		     PreparedStatement pstmt = conn.prepareStatement(
									"insert into board " 
								+ " (board_num, board_name, board_pass, board_subject, board_content,"
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
			 PreparedStatement pstmt1 = conn.prepareStatement(
						   "update board "
						+ " set board_re_seq = board_re_seq + 1 "
						+ " where board_re_ref = ? " 
						+ " and board_re_seq > ? ");

			 PreparedStatement pstmt2 = conn.prepareStatement(
							"insert into board " 
						+ " (board_num, board_name, board_pass, board_subject, board_content, "
						+ " board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date) "
						+ " values (board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 0, sysdate)");) {

			conn.setAutoCommit(false);

			pstmt1.setInt(1, board.getBoard_re_ref()); // 원본 글의 ref 값. 하위 글들은 해당 값을 참조하여 그룹화 된다.
			pstmt1.setInt(2, board.getBoard_re_seq()); // 원본 글에 대한 하위 글들의 갱신 순서. 최근일 수록 먼저 출력 된다.

			if (pstmt1.executeUpdate() > -1) {
				// 반환값은 그때 그때 다르지만 정확하게 수행하려면 먼저 수정될 대상의 수를 조회하여 변수 count로 설정하고
				// update 수행 반환 값이 count와 일치하면 다음 작업을 수행하도록 제약한다.

				pstmt2.setString(1, board.getBoard_name());
				pstmt2.setString(2, board.getBoard_pass());
				pstmt2.setString(3, board.getBoard_subject());
				pstmt2.setString(4, board.getBoard_content());
				pstmt2.setInt(5, board.getBoard_re_ref());
				pstmt2.setInt(6, (board.getBoard_re_lev() + 1)); // 출력 될 때 구분을 위한 변수. lev * 2 만큼 들여쓰기하여 구분한다.
				pstmt2.setInt(7, (board.getBoard_re_seq() + 1));

				int insert = pstmt2.executeUpdate();

				if (insert == 1) {
					conn.commit();
					return insert;

				} else {
					conn.rollback();
					return 0;
				}

			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}

		return 0;
	}

	

	public int boardModify(Board board) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			 PreparedStatement pstmt = conn.prepareStatement(
						 "update board "
					  + " set board_subject = ?, board_content = ? "
					  + " where board_num = ? ");) {
			
			pstmt.setString(1, board.getBoard_subject());
			pstmt.setString(2, board.getBoard_content());
			pstmt.setInt(3, board.getBoard_num());

			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return 0;
	}



	public int boardDelete(Board board) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			 PreparedStatement pstmt = conn.prepareStatement(
										"delete from board " 
								+ "      where board_re_ref = ? "
								+ "      and board_re_lev >= ? "
								+ "      and board_re_seq >= ? "
								+ "      and board_re_seq <= nvl((select min(board_re_seq)-1 "
								+ "                               from board "
								+ "                               where board_re_ref = ? "
								+ "                               and board_re_lev = ? "
								+ "		 						  and board_re_seq > ?) "
								+ "                               , " // 메인 쿼리에서 이미 lev와 seq 의 범위를 >= 로 정했으므로
								+ "                               (select max(board_re_seq) " // 같은 레벨의 글이 없으면
								+ "                                from board " // 같은 그룹의 최대 seq 값만 가져오면 된다.
								+ "                                where board_re_ref = ?))");) { 

			conn.setAutoCommit(false);

			pstmt.setInt(1, board.getBoard_re_ref());
			pstmt.setInt(2, board.getBoard_re_lev());
			pstmt.setInt(3, board.getBoard_re_seq());
			pstmt.setInt(4, board.getBoard_re_ref());
			pstmt.setInt(5, board.getBoard_re_lev());
			pstmt.setInt(6, board.getBoard_re_seq());
			pstmt.setInt(7, board.getBoard_re_ref());

			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}

		return 0;
	}

}
