package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessageTypeListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		String params = "[{\"fn\":\"GetMessageTypeList\",\"input\":{\"loginId\":\""+loginId+"\"}}]";
		System.out.println("client:"+params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		System.out.println(result);
		resp.getWriter().write(result);
	}
}
