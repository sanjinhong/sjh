package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.common.Constant;
import com.dao.impl.UserDAOImpl;
import com.dao.interfaces.IUserDAO;

import net.sf.json.JSONArray;

public class DealUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String yhdmParam = request.getParameter("yhdm");
		IUserDAO userDAO = new UserDAOImpl();
		
		if ("add".equals(type)) {

			String dwdm = Constant.USER_DWDM;
			String yhid = request.getParameter("yhid");
			String yhdm = dwdm + yhid;
			String yhkl = request.getParameter("yhkl");
			String yhxm = request.getParameter("yhxm");
			String yhxb = request.getParameter("yhxb");
			String yhbm = request.getParameter("yhbm");
			String csrq = request.getParameter("csrq");
			String pxh = request.getParameter("pxh");
			String sfjy = request.getParameter("sfjy");

			User user = new User();

			user.setDwdm(dwdm);
			user.setYhid(yhid);
			user.setYhdm(yhdm);
			user.setYhkl(yhkl);
			user.setYhxm(yhxm);
			user.setYhxb(yhxb);
			user.setYhbm(yhbm);
			user.setCsrq(csrq);
			user.setPxh(Integer.parseInt(pxh));
			user.setSfjy(sfjy);
			
			userDAO.insert(user);
		}else if("check".equals(type)){
			List<User> users = userDAO.selectUserByYhdm(yhdmParam);
			JSONArray json = JSONArray.fromObject(users);
			
	        response.getWriter().println(json);
		}else if("modify".equals(type)){
			
		}else if("remove".equals(type)){
			System.out.println(yhdmParam);
			userDAO.delete(yhdmParam);
		}
	}

}
