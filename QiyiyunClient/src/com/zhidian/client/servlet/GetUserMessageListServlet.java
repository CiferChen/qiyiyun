package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserMessageListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("GetUserMessageListServlet");
		String loginId = GlobalData.loginId;
		String params = "[{\"fn\":\"GetUserMessageList\",\"input\":{\"loginId\":\""+loginId+"\",\"messageType\":1}}]";
		//String result = Common.sendPost(Common.URL, "params=" + params);
		HttpClient httpClient = new HttpClient();
		String result = httpClient.post(Common.URL, "params=" + params, "UTF-8");
		resp.getWriter().write(result);
	}
}
