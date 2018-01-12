package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.common.CommonUtils;
import com.dao.impl.UserDAOImpl;
import com.dao.interfaces.IUserDAO;

import net.sf.json.JSONArray;

public class UserSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		IUserDAO  userDAO = new UserDAOImpl();
		
		String yhxm = (String)request.getParameter("yhxm");
		String yhbm = (String) request.getParameter("yhbm");
		String bm = (String) request.getParameter("bm");
		
		if(!"".equals(CommonUtils.trim(bm))){
			yhbm = bm;
		}
		List<User> list_users = userDAO.selectUser(yhxm,yhbm);
		JSONArray users = JSONArray.fromObject(list_users);
		System.out.println(users);
		response.getWriter().println(users);
	}

}
