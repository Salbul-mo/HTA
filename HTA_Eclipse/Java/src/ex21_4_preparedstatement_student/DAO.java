package ex21_4_preparedstatement_student;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	public int insert(Student3 s) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn
						.prepareStatement("insert into student " + "values(student_seq.nextval, ?, ?, ?, ?, ?, ?, "
								+ "(select grade from hakjum where ? between lowscore and hiscore))");) {
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

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		return 0;
	}

	public ArrayList<Student3> selectAll() {
		ArrayList<Student3> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("select * from student order by no");
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				Student3 temp = new Student3();
				temp.setNo(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setKor(rs.getInt(3));
				temp.setMath(rs.getInt(4));
				temp.setEng(rs.getInt(5));
				temp.setTot(rs.getInt(6));
				temp.setAvg(rs.getFloat(7));
				temp.setGrade(rs.getString(8));

				list.add(temp);
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		return list;
	}

	public Student3 select(int no) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("select * from student where no = ? ");) {

			pstmt.setInt(1, no);

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Student3 s = new Student3();
					s.setNo(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setKor(rs.getInt(3));
					s.setMath(rs.getInt(4));
					s.setEng(rs.getInt(5));
					s.setTot(rs.getInt(6));
					s.setAvg(rs.getFloat(7));
					s.setGrade(rs.getString(8));

					return s;
				}

			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		return null;
	}

	public int update(Student3 newStudent) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("update student set " + "name = ? ," + "kor = ? ,"
						+ "math = ? ," + "eng = ? ," + "tot = ? ," + "avg = ? , "
						+ "grade = (select grade from hakjum where ? between lowscore and hiscore) "
						+ " where no = ?");) {
			pstmt.setString(1, newStudent.getName());
			pstmt.setInt(2, newStudent.getKor());
			pstmt.setInt(3, newStudent.getMath());
			pstmt.setInt(4, newStudent.getEng());
			pstmt.setInt(5, newStudent.getTot());
			pstmt.setFloat(6, newStudent.getAvg());
			pstmt.setFloat(7, newStudent.getAvg());
			pstmt.setInt(8, newStudent.getNo());

			int result = pstmt.executeUpdate();

			return result;

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}

		return 0;
	}

	public int delete(int no) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement("delete from student where no = ?")) {
			pstmt.setInt(1, no);

			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		return 0;
	}

}
