package kr.co.ca;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTest {
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String USERNAME = "ca";
	private String PASSWORD = "ca";
	
	@Test
	public void test() {
		try {
			Class.forName(DRIVER);
			System.out.println("성공1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("성공2");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
