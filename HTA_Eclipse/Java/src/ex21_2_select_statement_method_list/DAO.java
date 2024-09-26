package ex21_2_select_statement_method_list;

import java.util.*;
import java.sql.*;

public class DAO {
	
	List<GoodsInfo> select() {
		List<GoodsInfo> list = new ArrayList<GoodsInfo>();
		
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
				
					GoodsInfo gi = new GoodsInfo();
					gi.setCode(rs.getString(1));
					//String code = rs.getString("code");
					//gi.setCode(code);
					gi.setName(rs.getString(2));
					//String name = rs.getString("name");
					//gi.setName(name);
					gi.setPrice(rs.getInt(3));
					//int price = rs.getInt("price");
					//gi.setPrice(price);
					gi.setMaker(rs.getString(4));
					//String maker = rs.getString("maker");
					//gi.setMaker(maker);
				
					list.add(gi);
				}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		return list; // null 을 넘기면 나중에 NullPointException 발생
	}
}
