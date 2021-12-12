package co.cindy.prj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static DataSource dataSource;
	private DataSource() {
		
	}
	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}
	public Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String uri = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "dev";
		String password = "dev";
		
		try {
			Class.forName(driver);
			conn =DriverManager.getConnection(uri, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
