package ex21_2_select_statement_method_list_2_try_with_resources;

import java.sql.*;
import java.util.*;

public class DriverList_Show {

	public static void main(String[] args) {

		// 클래스 패스에 있는 모든 JDBC 드라이버는 자동으로 DriverManager에 등록된다.
		Enumeration<Driver> drivers = DriverManager.getDrivers();

		// 등록된 드라이버 목록 출력
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();

			System.out.println("Driver: " + driver.getClass().getName());
			// Driver : oracle.jdbc.OracleDriver
		}
	}
}
