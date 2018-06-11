package jdbc.demo.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static DataSource dataSource;
	/*
	 * C3P0工具类
	 */
	
	static {
		dataSource = getDataSource();
	}
	
	
	public static DataSource getDataSource() {
		//返回资源池
		return new ComboPooledDataSource("c3p0-config");
	}
	
	public static Connection getConnection() {
		//返回Connection
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	

}
