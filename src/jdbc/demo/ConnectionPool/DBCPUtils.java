package jdbc.demo.ConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	
	static {
		getConfig();
	}
	
	public static void getConfig() {
		InputStream in = null;
		try {
			in = DBCPUtils.class.getClassLoader().getResourceAsStream("conf.properties");
			Properties pro = new Properties();
			pro.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
