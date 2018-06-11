package jdbc.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	
	static {
		
		getConf();
//		System.out.println(DRIVER);
//		System.out.println(URL);
//		System.out.println(USERNAME);
//		System.out.println(PASSWORD);
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void getConf() {
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("conf.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			DRIVER = pro.getProperty("DRIVER");
			URL = pro.getProperty("URL");
			USERNAME = pro.getProperty("USERNAME");
			PASSWORD = pro.getProperty("PASSWORD");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
}
