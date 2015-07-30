package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String fn;
	private String input;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		fn = new String(req.getParameter("fn").getBytes("ISO-8859-1"),"UTF-8");
		input = new String(req.getParameter("input").getBytes("ISO-8859-1"),"UTF-8");
		String params = "[{\"fn\":\""+fn+"\",\"input\":{\"loginId\":\""+loginId+"\""+input+"}}]";
		System.out.println("client:"+params);
		//String result = Common.sendPost(Common.URL, "params=" + params);
		HttpClient httpClient = new HttpClient();
		String result = httpClient.post(Common.URL, "params=" + params, "UTF-8");
		resp.getWriter().write(result);
	}
}
