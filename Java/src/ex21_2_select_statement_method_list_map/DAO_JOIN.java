package ex21_2_select_statement_method_list_map;

import java.util.*;
import java.sql.*;

public class DAO_JOIN {
	
	List<Map<String,Object>> select() {
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException cnfe) {
		System.out.println(cnfe.getMessage());
	}
	
	try ( Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dname as 부서이름, ename as 사원이름, deptno as 부서번호, sal as 급여 "
					+ "from emp natural join dept "
					+ "order by 부서이름" );)
	/*
	 * select dname, ename, emp.deptno, sal 
	 * from emp, dept 
	 * where emp.deptno=dept.deptno 
	 * order by deptno;
	 * 
	 * select dname, ename, deptno, sal 
	 * from emp join dept 
	 * using(deptno) 
	 * order by deptno;
	 */
	{ 
		while (rs.next()) {
			Map<String,Object> h = new HashMap<String,Object>();
			h.put("부서이름", rs.getString("부서이름"));
			h.put("사원이름", rs.getString("사원이름"));
			h.put("부서번호", rs.getInt("부서번호"));
			h.put("급여", rs.getInt("급여"));
			list.add(h);
		}
	} catch (SQLException se) {
		System.out.println(se.getMessage());
	}
	return list;
	}
}
