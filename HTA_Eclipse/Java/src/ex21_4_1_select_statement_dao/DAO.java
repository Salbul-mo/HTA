package ex21_4_1_select_statement_dao;

import java.sql.*;
import java.util.*;

public class DAO {

	ArrayList<Emp> selectAll() {
		ArrayList<Emp> list = new ArrayList<Emp>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from emp order by empno");) {
			while (rs.next()) {
				
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getString("hiredate").substring(0, 11));
				//e.setHiredate(rs.getDate("hiredate")); => hiredate 를 Date 타입으로 선언하여 바로 날짜 데이터 받아온다.
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
