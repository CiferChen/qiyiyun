package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModUserPsdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String oldPsd;
	private String newPsd;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		oldPsd = new String(req.getParameter("oldPsd").getBytes("ISO-8859-1"),"UTF-8");
		newPsd = new String(req.getParameter("newPsd").getBytes("ISO-8859-1"),"UTF-8");
		String params = "[{\"fn\":\"ModUserPsd\",\"input\":{\"loginId\":\""+loginId+"\",\"oldPsd\":\""+oldPsd+"\",\"newPsd\":\""+newPsd+"\"}}]";
		System.out.println("client:"+params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
