package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Depart;
import com.dao.impl.DepartDAOImpl;
import com.dao.interfaces.IDepartDAO;

import net.sf.json.JSONArray;

public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		IDepartDAO departDAO = new DepartDAOImpl();
		List<Depart> departs = departDAO.select();
		
		JSONArray depart = JSONArray.fromObject(departs);
		
		response.getWriter().println(depart);
	}

}
