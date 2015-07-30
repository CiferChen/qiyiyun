package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMessageTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String messageTypeName;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		System.out.println("AddMessageTypeServlet");
		messageTypeName = new String(req.getParameter("messageTypeName").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(messageTypeName);
		String params = "[{\"fn\":\"AddMessageType\",\"input\":{\"loginId\":\""+loginId+"\",\"messageTypeName\":\""+messageTypeName+"\"}}]";
		System.out.println("client:"+params);
		//String result = Common.sendPost(Common.URL, "params=" + params);
		HttpClient httpClient = new HttpClient();
		String result = httpClient.post(Common.URL, "params=" + params, "UTF-8");
		resp.getWriter().write(result);
	}
}
