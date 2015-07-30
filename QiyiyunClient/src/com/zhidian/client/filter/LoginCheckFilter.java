package com.zhidian.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhidian.client.servlet.GlobalData;

public class LoginCheckFilter implements Filter {
    /** 
     * 登陆页面 
     */  
    private String loginPage = "";  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;  
        HttpSession session = httpServletRequest.getSession();  
        if (session == null || GlobalData.loginId.equals("")) {  
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;  
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + loginPage);  
        } else {  
            chain.doFilter(request, response);  
        }  
    }  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
        this.loginPage = filterConfig.getInitParameter("loginPage");  
    }  
  
    public void destroy() {  
  
    } 

}
