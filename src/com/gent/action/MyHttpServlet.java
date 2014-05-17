package com.gent.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7066919084386427392L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
		//resp.sendRedirect("hello.jsp");
		//resp.getWriter().write("using httpservlet interface");
	}

}
