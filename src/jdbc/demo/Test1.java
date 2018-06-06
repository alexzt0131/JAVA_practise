package jdbc.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Test1 {
	/*
	 * ºÚµ•≤È—Ø
	*/
	public static void main(String[] args) throws Exception {
//		Connection conn = JDBCUtils.getConn();
	}
	
	@Test
	public void getAll() {
		Connection conn = JDBCUtils.getConn();
		String sql = "select * from product";
		ResultSet set = null;
		PreparedStatement prestmt;
		try {
			prestmt = conn.prepareStatement(sql);
			set = prestmt.executeQuery();
			while(set.next()) {
				System.out.println(set.getInt("pid") + ":" + set.getString("pname") + "-" + set.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
