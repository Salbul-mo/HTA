package ex21_4_2_statement_search;

import java.sql.*;
import java.util.*;

public class DAO {

	ArrayList<Emp> search(int menu, String search_word) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		String sql = switch (menu) {
		case 0 -> "select * from emp where empno = " + Integer.parseInt(search_word);
		case 1 -> "select * from emp where ename = " + "'" + search_word.toUpperCase() + "'";
		case 2 -> "select * from emp where job = " +  "'" + search_word.toUpperCase() + "'";
		case 3 -> "select * from emp where mgr = " + Integer.parseInt(search_word);
		case 4 -> "select * from emp where hiredate = " + "'"+search_word+"'";
		// 날짜 데이터 포맷 문제는 나중에 해결하자.
		case 5 -> "select * from emp where sal = " + Integer.parseInt(search_word);
		case 6 -> "select * from emp where comm = " + Integer.parseInt(search_word);
		case 7 -> "select * from emp where deptno = " + Integer.parseInt(search_word);
		default -> "select * from emp";
		};
		/*
		 * String column_name[] = {"empno","ename","job","mgr","hiredate","sal","comm","deptno");
		 * 
		 * String sql = "select * from emp";
		 * 
		 * if (menu != 8) { // 8 은 종료
		 * 		String single = "";
		 * 
		 * 		if (menu == 1 || menu == 2 || menu == 4) // ename 과 job , hiredate 는 ' ' 필요하니까
		 * 			single = "'";
		 * 
		 * 		sql = sql + " where " + column_name[menu] + "=" + single + search_word + single;
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
