package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewUserMessageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String receiverId;
	private String messageTitle;
	private String messageContent;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("NewUserMessageServlet");
		String loginId = GlobalData.loginId;
		receiverId = req.getParameter("receiverId");
		messageTitle = new String(req.getParameter("messageTitle").getBytes("ISO-8859-1"),"UTF-8");
		messageContent = new String(req.getParameter("messageContent").getBytes("ISO-8859-1"),"UTF-8");
		String params = "[{\"fn\":\"NewUserMessage\",\"input\":{\"loginId\":\""+loginId+"\",\"receiverId\":\""+receiverId+"\",\"messageTitle\":\""+messageTitle+"\",\"messageContent\":\""+messageContent+"\"}}]";
		System.out.println(params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
