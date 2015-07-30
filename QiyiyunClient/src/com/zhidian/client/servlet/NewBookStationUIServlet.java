package com.zhidian.client.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewBookStationUIServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String name;
	private String phoneNumber;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.name=req.getParameter("name");
		this.phoneNumber = req.getParameter("phone");
		String params = "[{\"fn\":\"NewBookStationUI\",\"input\":{\"bookStationName\":\""+this.name+"\",\"bookStationPhone\":\""+this.phoneNumber+"\"}}]";
		String result = Common.sendPost(Common.URL, "params=" + params);
		if(result.equals("error")){
			Random r = new Random();
			int errorIndex = r.nextInt(3);
			if(errorIndex==0){
				errorIndex+=1;
			}
			String resultIndex = "/error"+errorIndex+".html";
			resp.sendRedirect(req.getContextPath()+resultIndex);
		}
	}
}
