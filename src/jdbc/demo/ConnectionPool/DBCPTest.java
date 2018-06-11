package jdbc.demo.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBCPTest {

	
	public static void main(String[] args) throws Exception {
		
		
		
		System.out.println(insertRow());
		
	}
	
	
	
	public static int insertRow(){
		//使用C3P0链接池来获得Connection
		int row = 0;
		Connection conn = null;
		PreparedStatement prestmt;
		try {
			conn = DBCPUtils.getConn();
			String sql = "insert into student(name,sex,score) values('test1','男',33)";
			prestmt = conn.prepareStatement(sql);
			row = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	
}
