package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRegisteredSpaceInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418115367904156740L;
	private String registeredSpaceId;
	private String registeredSpaceName;
	private String registeredSpaceAddress;
	private String registeredSpaceX;
	private String registeredSpaceY;
	private String registeredSpaceDescription;
	private String registeredSpaceImg;
	private String registeredSpaceLeaderId;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginId = GlobalData.loginId;
		registeredSpaceId = new String(req
				.getParameter("registeredSpaceId").getBytes("ISO-8859-1"),
				"UTF-8");
		registeredSpaceName = new String(req
				.getParameter("registeredSpaceName").getBytes("ISO-8859-1"),
				"UTF-8");
		registeredSpaceAddress = new String(req.getParameter(
				"registeredSpaceAddress").getBytes("ISO-8859-1"), "UTF-8");
		registeredSpaceX = new String(req.getParameter("registeredSpaceX")
				.getBytes("ISO-8859-1"), "UTF-8");
		registeredSpaceY = new String(req.getParameter("registeredSpaceY")
				.getBytes("ISO-8859-1"), "UTF-8");
		registeredSpaceDescription = new String(req.getParameter(
				"registeredSpaceDescription").getBytes("ISO-8859-1"), "UTF-8");
		registeredSpaceImg = new String(req.getParameter("registeredSpaceImg")
				.getBytes("ISO-8859-1"), "UTF-8");
		registeredSpaceLeaderId = new String(req.getParameter(
				"registeredSpaceLeaderId").getBytes("ISO-8859-1"), "UTF-8");
		
		String params = "[{\"fn\":\"UpdateRegisteredSpaceInfo\",\"input\":{\"loginId\":\""
				+ loginId 
				+ "\",\"registeredSpaceId\":\"" + registeredSpaceId
				+ "\",\"registeredSpaceName\":\"" + registeredSpaceName
				+ "\",\"registeredSpaceAddress\":\"" + registeredSpaceAddress
				+ "\",\"registeredSpaceX\":\"" + registeredSpaceX
				+ "\",\"registeredSpaceY\":\"" + registeredSpaceY
				+ "\",\"registeredSpaceDescription\":\"" + registeredSpaceDescription
				+ "\",\"registeredSpaceImg\":\"" + registeredSpaceImg
				+ "\",\"registeredSpaceLeaderId\":\"" + registeredSpaceLeaderId + "\"}}]";
		System.out.println("client:" + params);
		String result = Common.sendPost(Common.URL, "params=" + params);
		resp.getWriter().write(result);
	}
}
