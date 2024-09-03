package ex21_4_3_statement_search2_and;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	ArrayList<Emp> search(String[] search_word) {
		ArrayList<Emp> list = new ArrayList<Emp>();

		String column_name[] = { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };

		String sql = "select * from emp";
		
		boolean first = true;

		for (int i = 0; i < search_word.length; i++) {
			String single = "";

			if (i == 1 || i == 2 || i == 4)
				single = "'";

			if (!(search_word[i] == null)) {

				if (first) {
					sql = sql + " where " + column_name[i] + " = " + single + search_word[i] + single;
					first = false;
				} else {
					sql = sql + " and " + column_name[i] + " = " + single + search_word[i] + single;
				}
			}
		}
		/*
		 * for (int i = 0; i < searchs.length; i++) {
		 * 		if(search_word[i] != null) {
		 * 			String single = "";
		 * 		
		 * 			if (i == 1 || i == 2 || i == 4) 
		 * 				single = "'";
		 * 			
		 * 			if (sql.contains("where")) // where 이 포함되어 있는지 확인
		 * 				sql += " and ";
		 * 			else
		 * 				sql += " where ";
		 * 
		 * 			sql += column_name[i] + "=" + single + search_word[i] + single;
		 * 		}
		 * }
		 */

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {

				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getString("hiredate").substring(0, 11));
				// e.setHiredate(rs.getDate("hiredate")); => hiredate 를 Date 타입으로 선언하여 바로 날짜 데이터
				// 받아온다.
				e.setSal(rs.getInt("sal"));
				e.setComm(rs.getInt("comm"));
				e.setDeptno(rs.getInt("deptno"));

				list.add(e);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());

		}

		return list;
	}
}
