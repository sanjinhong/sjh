package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	/**
	 * 获取数据库连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return void
	 * @author sanjh
	 * @time 2017-12-21
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException {

		String driver = "com.sybase.jdbc3.jdbc.SybDriver";
		String url = "jdbc:sybase:Tds:localhost:5000/test?charset=cp936";
		String user = "sa";
		String password = "";
		
		//加载sybase数据库驱动
		Class.forName(driver);
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	/**
	 * 关闭数据库连接资源
	 * @param conn 数据库连接
	 * @param st
	 * @param rs 结果集
	 * @return void
	 * @author sanjh
	 * @throws SQLException
	 * @time 2017-12-21
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
