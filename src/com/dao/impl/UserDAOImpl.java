package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.beans.User;
import com.common.CommonUtils;
import com.common.JdbcUtils;
import com.dao.interfaces.IBzdmDAO;
import com.dao.interfaces.IDepartDAO;
import com.dao.interfaces.IUserDAO;

public class UserDAOImpl implements IUserDAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<User> selectUser(String yhxm,String yhbm){
		
		IBzdmDAO bzdmDAO = new BzdmDAOImpl();
		Map<String, String> xb = bzdmDAO.getXbmc();
		
		IDepartDAO departDAO = new DepartDAOImpl();
		Map<String, String> map_depart = departDAO.select2();
		
		List<User> list_users = new ArrayList<>();
		String sql = null;
		try {
			conn = JdbcUtils.getConn();
			if(!"".equals(CommonUtils.trim(yhxm))){
				sql = "SELECT YHDM,DWDM,YHID,YHXM,YHKL,YHXB,YHBM,CSRQ,PXH,SFJY " + 
					  "FROM T_USER WHERE YHXM LIKE '%" + yhxm +"%'"; 
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}else if(!"".equals(CommonUtils.trim(yhbm))){
				sql = "SELECT YHDM,DWDM,YHID,YHXM,YHKL,YHXB,YHBM,CSRQ,PXH,SFJY " + 
					  "FROM T_USER WHERE YHBM = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, yhbm);
				rs = ps.executeQuery();
			}else{
				sql = "SELECT YHDM,DWDM,YHID,YHXM,YHKL,YHXB,YHBM,CSRQ,PXH,SFJY FROM T_USER";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			while(rs.next()){
				User user = new User();
				user.setYhdm(rs.getString("YHDM"));
				user.setDwdm(rs.getString("DWDM"));
				user.setYhid(rs.getString("YHID"));
				user.setYhxm(rs.getString("YHXM"));
				user.setYhkl(rs.getString("YHKL"));
				user.setYhxb(xb.get(rs.getString("YHXB")));
				user.setYhbm(map_depart.get(rs.getString("YHBM")));
				user.setCsrq(rs.getString("CSRQ"));
				user.setPxh(rs.getInt("PXH"));
				user.setSfjy(rs.getString("SFJY"));
				
				list_users.add(user);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
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
		return list_users;
	}
	
	@Override
	public void insert(User user){
		try {
			conn = JdbcUtils.getConn();
			String sql = " INSERT INTO T_USER(YHDM,DWDM,YHID,YHXM,YHKL,YHXB,YHBM,CSRQ,PXH,SFJY) " + 
						 " VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getYhdm());
			ps.setString(2, user.getDwdm());
			ps.setString(3, user.getYhid());
			ps.setString(4, user.getYhxm());
			ps.setString(5, user.getYhkl());
			ps.setString(6, user.getYhxb());
			ps.setString(7, user.getYhbm());
			ps.setString(8, user.getCsrq());
			ps.setInt(9, user.getPxh());
			ps.setString(10, user.getSfjy());
			
			ps.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
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
	}
	
	@Override
	public void delete(String yhdm){
		try {
			conn = JdbcUtils.getConn();
			String sql = " DELETE FROM T_USER WHERE YHDM = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, yhdm);
			ps.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
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
	}
	@Override
	public void update(User user){
		try {
			conn = JdbcUtils.getConn();
			String sql = " UPDATE T_USER SET YHDM=?,DWDM=?,YHXM=?,YHKL=?,YHXB=?,YHBM=?,CSRQ=?,PXH=?,SFJY=? WHERE YHID = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getYhdm());
			ps.setString(2, user.getDwdm());
			
			ps.setString(3, user.getYhxm());
			ps.setString(4, user.getYhkl());
			ps.setString(5, user.getYhxb());
			ps.setString(6, user.getYhbm());
			ps.setString(7, user.getCsrq());
			ps.setInt(8, user.getPxh());
			ps.setString(9, user.getSfjy());
			ps.setString(10, user.getYhid());
			
			ps.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
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
	}

	@Override
	public List<User> selectUserByYhdm(String yhdmParam) {
		IBzdmDAO bzdmDAO = new BzdmDAOImpl();
		Map<String, String> xb = bzdmDAO.getXbmc();
		
		List<User> list_users = new ArrayList<>();
		try {
			conn = JdbcUtils.getConn();
			String sql = "SELECT YHDM,DWDM,YHID,YHXM,YHKL,YHXB,YHBM,CSRQ,PXH,SFJY " + 
					  "FROM T_USER WHERE YHDM=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, yhdmParam);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				
				user.setYhdm(rs.getString("YHDM"));
				user.setDwdm(rs.getString("DWDM"));
				user.setYhid(rs.getString("YHID"));
				user.setYhxm(rs.getString("YHXM"));
				user.setYhkl(rs.getString("YHKL"));
				user.setYhxb(xb.get(rs.getString("YHXB")));
				user.setYhbm(rs.getString("YHBM"));
				user.setCsrq(rs.getString("CSRQ"));
				user.setPxh(rs.getInt("PXH"));
				user.setSfjy(rs.getString("SFJY"));
				
				list_users.add(user);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
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
		return list_users;
	}
}
