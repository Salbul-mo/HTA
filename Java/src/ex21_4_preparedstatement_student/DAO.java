package ex21_4_preparedstatement_student;

import java.sql.*;

public class DAO {

	public int insert(Student3 s) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			 PreparedStatement pstmt = 
				conn.prepareStatement("insert into student "
					+ "values(student_seq.nextval, ?, ?, ?, ?, ?, ?, "
						+ "(select grade from hakjum where ? between lowscore and hiscore))");
			)
		{	
			conn.setAutoCommit(false);
			
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getKor());
			pstmt.setInt(3, s.getMath());
			pstmt.setInt(4, s.getEng());
			pstmt.setInt(5, s.getTot());
			pstmt.setFloat(6, s.getAvg());
			pstmt.setFloat(7, s.getAvg());
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				conn.commit();
				System.out.println("db에 반영됨. . . . .");
				return result;
			}
			
			
		} catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		return 0;
	}

}
