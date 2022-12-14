package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	static Connection conn = null;
	 
	public static  Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/thong_tin";
		final String username = "root";
		final String password = "";
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
				
			conn = (Connection) DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return conn;
	}

	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
