package ex21_2_select_statement_method_list_map;

import java.sql.*;
import java.util.*;

public class DAO {
	
	List<Map<String,Object>> select() {
		List<Map<String,Object>> list = new ArrayList<>(); //Map 을 담을 List 생성
		
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");		
		} catch(ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
			cnfe.getStackTrace();
		}
		
		try (
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from goodsinfo");
			)

		{	
			
				while (rs.next()) {
				
					Map<String, Object> h = new HashMap<String,Object>(); 
					// 컬럼명을 담을 String 타입 key, 데이터 타입이 여러가지이므로 Object로 받는 value Map 객체 생성 
					h.put("code", rs.getString(1));
					//h.put("code",rs.getString("code"));
					h.put("name",rs.getString(2));
					//h.put("name",rs.getString("name"));
					h.put("price",rs.getInt(3));
					//h.put("price",rs.getInt("price"));
					h.put("maker",rs.getString(4));
					//h.put("maker",rs.getString("maker"));
				
					list.add(h); // list에 객체 저장
				}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		return list; // null 을 넘기면 나중에 NullPointException 발생
	}
}
