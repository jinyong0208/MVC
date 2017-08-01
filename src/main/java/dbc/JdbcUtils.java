package dbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource dataSource;
	private static Connection conn;
	static {
		dataSource = new ComboPooledDataSource("postgresql");
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得Connection对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		return conn;
	}

	/**
	 * 释放Connection链接
	 */
	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
