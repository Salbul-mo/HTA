package ex8_emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO_EMP {
	
	private DataSource ds;
	
	public DAO_EMP(){
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
		
	}
	
	public ArrayList<Emp> selectAll() {
		
		ArrayList<Emp> list = new ArrayList<>();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement psmt = conn.prepareStatement("select empno, ename, job, mgr, hiredate, sal, nvl(comm, 0) as comm, deptno from emp");
				ResultSet rs = psmt.executeQuery();)
		{
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate").toString().substring(0, 11));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		return list;
	}
}
