package com.cw.chwo.web.common.listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by handl on 2017/5/24.
 */
public class MyListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {

    private HttpSession httpSession;
    private ServletContext servletContext;
    private HttpServletRequest httpServletRequest;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSession = httpSessionEvent.getSession();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if (httpSession != null){
            httpSession = null;
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (servletContext != null){
            servletContext = null;
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        if (httpServletRequest != null){
            httpServletRequest = null;
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        httpServletRequest = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String uri = httpServletRequest.getRequestURI();
        System.out.println("Listen uri = " + uri);
        uri = httpServletRequest.getQueryString() == null ? uri : (uri + "?" + httpServletRequest.getQueryString());
        httpServletRequest.setAttribute("dateCreated", System.currentTimeMillis());
    }
}
