package com.javaee.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.javaee.bean.User;


@WebFilter
public class LifeFilter implements Filter {

	public void destroy() {
		// Filter销毁
		System.out.println("请求销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Filter核心方法
		
		//request2.getSession();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		

		// redis
/*		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"spring-redis.xml");
		final RedisTemplate<String, Object> redisTemplate = appCtx.getBean(
				"redisTemplate", RedisTemplate.class);
		
		// 添加一个 key
		ValueOperations<String, Object> value = redisTemplate.opsForValue();
		// 获取 这个 key 的值
		System.out.println(value.get("user"));
		

		if (value.get("user") != null) {
			MANAGE_USEREntity curUser = (MANAGE_USEREntity) value.get("user");
			System.out.println("当前用户：" + curUser.getNAME());
		}*/
		User user = new User();
		user.setName("张三");
		session.setAttribute("user", user);
		
		
		if (session.getAttribute("user") != null) {
			User curUser = (User) session
					.getAttribute("user");
			System.out.println("当前用户：" + curUser.getName());
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Filter初始化
		System.out.println("请求初始化");
	}

}
