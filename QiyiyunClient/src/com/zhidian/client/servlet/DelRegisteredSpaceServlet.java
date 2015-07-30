package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelRegisteredSpaceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String registeredSpaceId;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		registeredSpaceId = new String(req
				.getParameter("registeredSpaceId").getBytes("ISO-8859-1"),
				"UTF-8");
		String params = "[{\"fn\":\"DelRegisteredSpace\",\"input\":{\"loginId\":\""
				+ loginId 
				+ "\",\"registeredSpaceId\":\"" + registeredSpaceId + "\"}}]";
		System.out.println("client:" + params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
