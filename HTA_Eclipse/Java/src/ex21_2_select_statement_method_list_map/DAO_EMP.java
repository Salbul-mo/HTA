package ex21_2_select_statement_method_list_map;

import java.util.*;
import java.sql.*;

public class DAO_EMP {

	public List<Map<String, Object>> select() {
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
			cnfe.getStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select deptno as 부서번호, max(sal) as 최고급여, count(empno) as 부서인원수 from emp group by deptno order by deptno desc");
				) 
		{
			while (rs.next()) {

				Map<String, Object> h = new HashMap<String, Object>();
				/*
				 * 별칭으로 데이터 접근하는 방법
				 * java.sql.ResultSet.getObject(String columnLabel) throws SQLException
				 */
				h.put("부서번호", rs.getInt("부서번호"));
				// h.put("부서번호", rs.getInt(1));
				h.put("최고급여", rs.getInt("최고급여"));
				// h.put("최고급여", rs.getInt(2));
				h.put("부서인원수", rs.getInt("부서인원수"));
				// h.put("부서인원수",rs.getInt(3));

				list.add(h);
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		return list;
	}
}
