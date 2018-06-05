package jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	
	private static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Aa123456!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
}
