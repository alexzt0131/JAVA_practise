package demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {

	public static void main(String[] args) throws Exception {
		
		
		
		Connection conn = JDBCUtils.getConn();
		
		
		String sql = "select * from product";
		
		PreparedStatement prestmt = conn.prepareStatement(sql);
		
		ResultSet set = prestmt.executeQuery();
		
		while(set.next()) {
			System.out.println(set.getInt("pid") + ":" + set.getString("pname"));
		}
		
		
		
	}

}
