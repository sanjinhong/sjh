package com.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.common.JdbcUtils;

public class BmFilter implements Filter {

	public static Map<String,String> map;
	
	public BmFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT BMDM,BMMC FROM T_DEPART";
		//存放所有部门代码和对应的部门名称
		map = new HashMap<>();
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//取出查询结果集的所有部门名称并放入Map
			while(rs.next()){
				
				String bmdm = rs.getString("BMDM");
				String bmmc = rs.getString("BMMC");
				map.put(bmdm, bmmc);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
