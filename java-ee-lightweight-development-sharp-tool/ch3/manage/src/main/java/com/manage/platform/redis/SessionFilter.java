/*package com.manage.platform.redis;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manage.platform.redis.StringUtils;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(SessionFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //从cookie中获取sessionId，如果此次请求没有sessionId，重写为这次请求设置一个sessionId
        String sid = CookieUtil.getCookieValue(request, GlobalConstant.JSESSIONID);
        if(StringUtils.isEmpty(sid) || sid.length() != 36){
            sid = StringUtils.getUuid();
            CookieUtil.setCookie(request, response, GlobalConstant.JSESSIONID, sid, 60 * 60); 
        }

        //交给自定义的HttpServletRequestWrapper处理
        filterChain.doFilter(new HttpServletRequestWrapper(sid, request, response), response);
    }

}*/