package ex21_2_select_statement_method_list_map;

import java.sql.*;
import java.util.*;

public class DAO_Practice {
	
	List<Map<String,Object>> list = new ArrayList<>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException cnfe) {
		System.out.println("클래스가 없습니다.");
		cnfe.getStackTrace();
	}
	
	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp natural join dept");)
	{ 
		while(rs.next()) {
			Map<String,Object> h = new HashMap<>();
		}
	} catch (SQLException se) {
		System.out.println(se.getMessage());
	}
}
	
	



