package ex21_3_insert_delete_update;

import java.sql.*;

public class JDBCExample4_Oracle_insert_input0_problem {
	
	public static void main(String args[]) {
		if (args.length != 4) {
			System.out.println("상품코드 상품명 가격 제조사를 입력하세요.");
			return;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				Statement stmt = conn.createStatement();)
		
		{	
			/*
				arguments 를 사용해서 입력하는 경우
				A2000 모니터 200 삼성 
				
				입력 데이터 타입을 구분짓는게 중요하다
				문자열을 '' 로 감싸준다.
				insert into goodsinfo (code, name, price, maker)
				values ('args[0]', 'args[1]', args[2], 'args[3]')
				
				String single = "'"; 로 지정해놓고
				single + args[0]+ single 이런식으로 사용할 수 도 있다. 
			 */
			
			String sql = "insert into goodsinfo values('"+args[0]+"','"+args[1]+"','"+args[2]+"','"+args[3]+"')";
			// 숫자 타입에도 ''를 넣었는데 정상 작동 아마도 sql 에서 자동 형변환이 일어나 int로 입력된 것 같다.
			System.out.println(sql);
			
			/*
			 * Insert, Update, Delete 문을 실행하는 메서드는 executeUpdate() 이다.
			 * executeUpdate() 의 리턴값은 DML 이 수행된 row의 수이다. (int 반환)
			 */
			
			int rowNum =stmt.executeUpdate(sql);
			System.out.println(rowNum + "행이 추가되었습니다.");
			
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
