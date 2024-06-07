package com.manage.platform;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("拦截器执行！");

	}

	public String intercept(ActionInvocation Invocation) throws Exception {
		// TODO Auto-generated method stub
		// 获取ulr request
		ActionContext context = Invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		// 获取session
		HttpSession session = request.getSession();
		// 获取请求路径
		String path = request.getRequestURI();
		// 判断是否登录
		if (session.getAttribute("user") == null) {
			request.getRequestDispatcher("/login.jsp");
		}
		return Invocation.invoke();
	}

}
