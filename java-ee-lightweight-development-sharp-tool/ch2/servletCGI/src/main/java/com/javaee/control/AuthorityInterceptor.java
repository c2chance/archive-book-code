package com.javaee.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @ClassName AuthorityInterceptor
 * @Author ����
 * @Description TODO ������
 * @Version 1.0
 */

public class AuthorityInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //��������ԶԲ�����һЩԤ�������һЩ��֤
    	System.out.println();
        return true;//��������ִ�У���������controller�ķ�������ִ��
        //false ��������������֮ǰ��reponse�б�д���صĽ��

    }
    //����modelǰ

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //Controllerִ����Ϻ󣬷���֮ǰ�����Զ�request��reponse���д���
        //�����ǰ���û�з��룬�ڽ���View����ǰִ��
    	System.out.println();
    }

    //����model��

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //��һ����������ϣ��������ٵ�ʱ��ִ�У�������һЩ��Դ�ͷ�֮��Ĺ���
    	System.out.println();
    }
}
