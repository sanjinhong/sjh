package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.Depart;
import com.common.JdbcUtils;
import com.dao.interfaces.IDepartDAO;

public class DepartDAOImpl implements IDepartDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Depart> select(){
		List<Depart> departs = new ArrayList<>();
		try {
			String sql = "SELECT BMDM,BMMC,FBMDM FROM T_DEPART";
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Depart depart = new Depart();
				depart.setBmdm(rs.getString("BMDM"));
				depart.setBmmc(rs.getString("BMMC"));
				depart.setFbmdm(rs.getString("FBMDM"));
				
				departs.add(depart);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return departs;
	}
	@Override
	public	Map<String,String> select2(){
		Map<String,String> map = new HashMap<>();
		try {
			String sql = "SELECT BMDM,BMMC FROM T_DEPART";
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				map.put(rs.getString("BMDM"), rs.getString("BMMC"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
}
