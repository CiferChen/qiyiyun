package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelMessageTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String messageTypeId;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		System.out.println("DelMessageTypeServlet");
		messageTypeId = new String(req.getParameter("messageTypeId").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(messageTypeId);
		String params = "[{\"fn\":\"DelMessageType\",\"input\":{\"loginId\":\""+loginId+"\",\"messageTypeId\":\""+messageTypeId+"\"}}]";
		System.out.println("client:"+params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
