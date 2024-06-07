package com.manage.platform;

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

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest) request).getSession();
		System.err.println(session.getAttribute("user"));
		System.out.println(((HttpServletRequest) request).getRequestURL());
		StringBuffer url = ((HttpServletRequest) request).getRequestURL();
		if(url.toString().contains(".action")&& !url.toString().contains("USERLogin.action"))
		{
			if(session.getAttribute("user")==null)
			{
				//((HttpServletResponse)response).sendRedirect("/card/login.jsp");
				((HttpServletRequest)request).getRequestDispatcher("/login.jsp");
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
		else
		{
			chain.doFilter(request, response);
		}
			

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
