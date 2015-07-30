package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserIsExistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String username;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CheckUserIsExistServlet");
		this.username = req.getParameter("username");
		String params = "[{\"fn\":\"CheckUserIsExist\",\"Input\":{\"Type\":0,\"TypeEx\":\""+this.username+"\"}}]";
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
