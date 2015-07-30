package com.zhidian.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431430892643244256L;
	private String username;
	private String password;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session = req.getSession(true);
		session.setMaxInactiveInterval(Configuration.SESSIONLIFE);
		this.username = req.getParameter("username");
		this.password = req.getParameter("password");
		Gson gson = new Gson();
		String params = "[{\"fn\":\"UserLogin\",\"input\":{\"userName\":\""
				+ this.username + "\",\"userPsd\":\"" + this.password + "\"}}]";
		//String result = Common.sendPost(Common.URL, "params=" + params);
		HttpClient httpClient = new HttpClient();
		String result = httpClient.post(Common.URL, "params=" + params, "UTF-8");
		JsonParser jp = new JsonParser();
		JsonElement el = jp.parse(result);
		if (el.isJsonArray()) {
			JsonArray ja = el.getAsJsonArray();
			if (ja.size() > 0) {
				JsonElement je = ja.get(0);
				StandardOutput so = gson.fromJson(je, StandardOutput.class);
				if(1==so.result){
					resp.getWriter().write("login failed");
				}else{
					UserLogin ul = gson.fromJson(je, UserLogin.class);
					GlobalData.loginId = ul.output.loginID;
					resp.sendRedirect(req.getContextPath()+"/interfacelist.jsp");
				}
			} else {
				resp.getWriter().write("login failed");
			}
		} else {
			UserLogin ul = gson.fromJson(result, UserLogin.class);
			if (ul != null && ul.getResult() == 0) {
				GlobalData.loginId = ul.output.loginID;
				resp.sendRedirect(req.getContextPath()+"/interfacelist.jsp");
			} else {
				resp.getWriter().write("login failed");
			}
		}
	}
}
