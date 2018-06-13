package jdbc.demo.DBUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import jdbc.bean.Student;
import jdbc.demo.ConnectionPool.C3P0Utils;

public class DBUtilsTest {
	
	private	static QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	
	
	public static void main(String[] args) {
		
//		int row = insert();
//		getStudentById(3);
//		fetchAll();
		long count = countStudnet();
		System.out.println(count);
	}
	
	
	private static long countStudnet() {
		//ScalarHandler用于单数据类似count(*)的操作
		String sql = "select count(*) from student";
		try {
			return (long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	private static void fetchAll() {
		String sql = "select * from student";
		try {
			List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
			for (Student student : list) {
				System.out.println(student.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void getStudentById(int id) {
		String sql = "select * from student where id=?";
		Object[] param = {id};
		
		try {
			Student student = qr.query(sql, new BeanHandler<Student>(Student.class), param);
			System.out.println(student.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int insert() {
		String sql = "insert into student(name,sex,score) values(?,?,?)";
		Object[] param = {"alex33", "男", 33};
		try {
			int row = qr.update(sql, param);
			return row;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
