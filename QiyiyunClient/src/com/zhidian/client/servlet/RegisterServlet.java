package com.zhidian.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1470061929348122965L;
	private String username;
	private String password;
	private String code;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.username=request.getParameter("username");
			this.password = request.getParameter("password");
			System.out.println(this.username);
			if(this.username.contains("@")){
				//邮箱注册
				String activeURL = "http://127.0.0.1:8080/QiyiyunClient/active.jsp";
				String params = "[{\"fn\":\"RegAndSendByEmail\",\"Input\":{\"UserName\":\""
					+ this.username + "\",\"EmailAddr\":\"" + this.username + "\",\"Password\":\""+this.password+"\",\"ActiveUrl\":\""+activeURL+"\"}}]";
				String result = Common.sendPost(Common.URL, "params=" + params);
				Gson gson = new Gson();
				JsonParser jp = new JsonParser();
				JsonElement el = jp.parse(result);
				if (el.isJsonArray()) {
					JsonArray ja = el.getAsJsonArray();
					if (ja.size() > 0) {
						JsonElement je = ja.get(0);
						System.out.println(je);
						StandardOutput so = gson.fromJson(je, StandardOutput.class);
						System.out.println(so.result);
						if(1==so.result){
							response.getWriter().write("login failed");
						}else{
							response.sendRedirect(request.getContextPath()+"/index.jsp");
						}
					} else {
						response.getWriter().write("login failed");
					}
				} 
			}else if(Common.isMobileNO(this.username)){
				//手机注册
				this.code = request.getParameter("code");
				String params = "[{\"fn\":\"CompltRegByPhone\",\"input\":{\"userName\":\""
					+ this.username + "\",\"phoneNumb\":\"" + this.username + "\",\"password\":\""+this.password+"\",\"regCode\":\""+this.code+"\"}}]";
				String result = Common.sendPost(Common.URL, "params=" + params);
				Gson gson = new Gson();
				JsonParser jp = new JsonParser();
				JsonElement el = jp.parse(result);
				if (el.isJsonArray()) {
					JsonArray ja = el.getAsJsonArray();
					if (ja.size() > 0) {
						JsonElement je = ja.get(0);
						System.out.println(je);
						StandardOutput so = gson.fromJson(je, StandardOutput.class);
						System.out.println(so.result);
						if(1==so.result){
							response.getWriter().write("login failed");
						}else{
							response.sendRedirect(request.getContextPath()+"/index.jsp");
						}
					} else {
						response.getWriter().write("login failed");
					}
				} 
			}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
