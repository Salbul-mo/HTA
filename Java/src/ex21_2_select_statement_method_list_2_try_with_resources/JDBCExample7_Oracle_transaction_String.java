package ex21_2_select_statement_method_list_2_try_with_resources;

import java.sql.*;

public class JDBCExample7_Oracle_transaction_String {

	public static void main(String args[]) {
		/*
		 * transaction : 논리적인 작업 단위
		 * 
		 * insert, update, delete 등의 작업들을 하나의 논리적인 작업단위로
		 * 묶어서 쿼리 실행시 모든 작업이 정상 처리 된 경우에는 commit을 실행해서
		 * db에 반영하고 쿼리 실행 중 하나라도 정상처리 되지 않는 경우
		 * rollback 을 실행해서 작업 단위 내의 모든 작업을 취소한다.
		 * 
		 */
		
		// SQL 작성
		String sql1 = "insert into goodsinfo values(?,?,?,?) ";
		String sql2 = "update goodsinfo set price = ? where code = ? ";
		
	
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);	) 
		{
			conn.setAutoCommit(false);
			
			//1번 작업 시작
			
			// 쿼리의 ?에 대체될 실제 값 지정하기
			pstmt1.setString(1, "10006");
			pstmt1.setString(2,"공기청정기");
			pstmt1.setInt(3, 500000);
			pstmt1.setString(4,"코웨이");
			int result = pstmt1.executeUpdate();
			//1번 작업 종료
			
			//2번 작업 시작
			
			// 쿼리의 ? 에 대체될 실제 값 지정하기
			pstmt2.setInt(1, 100);
			pstmt2.setString(2, "10001");
			int result2 = pstmt2.executeUpdate();
			//2번 작업 종료
			
			//쿼리가 정상적으로 실행된 경우 db에 반영
			if(result ==1 && result2 == 1) {
				conn.commit();
				System.out.println("db에 반영됨 . . . .");
			} else {
				conn.rollback();
				System.out.println("db 반영이 취소 됨 . . . .");
			}
		} catch (SQLException se) {
				System.out.println(se.getMessage());
		}
		// transaction 종료
		
	}
}

