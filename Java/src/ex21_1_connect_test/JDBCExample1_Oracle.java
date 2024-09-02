package ex21_1_connect_test;

import java.sql.*;

public class JDBCExample1_Oracle {

	public static void main(String args[]) {

		Connection conn = null;

		try {
			// 1단계 : JDBC 드라이버를 로드한다.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			/*
			 * Class<?> java.lang.Class.forName(String className) throws
			 * ClassNotFoundException
			 * 
			 * 
			 * @CallerSensitive
			 * 
			 * 
			 * Returns the Class object associated with the class or interface with the given string name. 
			 * Invoking this method is equivalent to: 
			 * 
			 * Class.forName(className, true, currentLoader) 
			 * 
			 * where currentLoader denotes the defining class loader of the current class.
			 * 
			 * For example, the following code fragment returns 
			 * the runtime Class descriptor for the class named java.lang.Thread:
			 * 
			 * Class t = Class.forName("java.lang.Thread")
			 * 
			 * A call to forName("X") causes the class named X to be initialized.
			 * 
			 * Parameters: className the fully qualified name of the desired class.
			 * Returns: the Class object for the class with the specified name.
			 * Throws: LinkageError - if the linkage fails
			 * ExceptionInInitializerError - if the initialization provoked by this method fails
			 * ClassNotFoundException - if the class cannot be located
			 */

			// 2단계 : DB에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			/*
			 * The basic service for managing a set of JDBC drivers. 
			 * NOTE: The javax.sql.DataSource interface, provides another way to connect to a data source.
			 * The use of a DataSource object is the preferred means of connecting to a data source. 
			 * As part of its initialization, the DriverManager class will attempt to load available JDBC drivers by using: 
			 * 
			 * •The jdbc.drivers system property which contains a colon separated list of fully qualified 
			 * 
			 * class names of JDBC drivers. Each driver is loaded using the system class loader:
			 * 
			 * 	 ◦jdbc.drivers=foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver 
			 * 
			 * •Service providers of the java.sql.Driver class, that are loaded via the service-provider loading mechanism. 
			 * 
			 * DriverConnectionImpl Note: DriverManager initialization is done lazily and looks up service providers
			 * using the thread context class loader. The drivers loaded and available to an application will depend on the thread
			 * context class loader of the thread that triggers driver initialization by DriverManager. 
			 * When the method getConnection is called,
			 * the DriverManager will attempt to locate a suitable driver from amongst those loaded at initialization and 
			 * those loaded explicitly using the same class loader as the current application.
			 * 
			 */

			// 3단계 : 메시지 출력 명령문으로 대체
			System.out.println("데이터베이스에 접속했습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			if (conn != null)
				try {
					conn.close(); // 4단계 : DB연결을 끊는다.
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}

}
