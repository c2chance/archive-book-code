/*package com.manage.platform.redis;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*//**
 * 创建时间：2016年1月21日 下午7:55:41
 * 
 * @author andy
 * @version 2.2
 *//*

public class HttpSessionWrapper implements HttpSession {

    private String sid = "";

    private HttpSession session;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private Map<String, Object> map = null;

    private SessionService sessionService = (SessionService) SpringContextHolder.getBean("sessionService");

    public HttpSessionWrapper() {
    }

    public HttpSessionWrapper(HttpSession session) {
        this.session = session;
    }

    public HttpSessionWrapper(String sid, HttpSession session) {
        this(session);
        this.sid = sid;
    }

    public HttpSessionWrapper(String sid, HttpSession session,
            HttpServletRequest request, HttpServletResponse response) {
        this(sid, session);
        this.request = request;
        this.response = response;
    }

    private Map<String, Object> getSessionMap() {
        if (this.map == null) {
            this.map = sessionService.getSession(this.sid);
        }
        return this.map;
    }

    @Override
    public Object getAttribute(String name) {
        if (this.getSessionMap() != null) {
            Object value = this.getSessionMap().get(name);
            return value;
        }
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {
        this.getSessionMap().put(name, value);
        sessionService.saveSession(this.sid, this.getSessionMap());
    }

    @Override
    public void invalidate() {
        this.getSessionMap().clear();
        sessionService.removeSession(this.sid);
        CookieUtil.removeCookieValue(this.request,this.response, GlobalConstant.JSESSIONID);
    }

    @Override
    public void removeAttribute(String name) {
        this.getSessionMap().remove(name);
        sessionService.saveSession(this.sid, this.getSessionMap()); 
    }

    @Override
    public Object getValue(String name) {
        return this.session.getValue(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Enumeration getAttributeNames() {
        return (new Enumerator(this.getSessionMap().keySet(), true));
    }

    @Override
    public String[] getValueNames() {
        return this.session.getValueNames();
    }

    @Override
    public void putValue(String name, Object value) {
        this.session.putValue(name, value);
    }

    @Override
    public void removeValue(String name) {
        this.session.removeValue(name);
    }

    @Override
    public long getCreationTime() {
        return this.session.getCreationTime();
    }

    @Override
    public String getId() {
        return this.sid;
    }

    @Override
    public long getLastAccessedTime() {
        return this.session.getLastAccessedTime();
    }

    @Override
    public ServletContext getServletContext() {
        return this.session.getServletContext();
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        this.session.setMaxInactiveInterval(interval);
    }

    @Override
    public int getMaxInactiveInterval() {
        return this.session.getMaxInactiveInterval();
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return this.session.getSessionContext();
    }

    @Override
    public boolean isNew() {
        return this.session.isNew();
    }

}*/