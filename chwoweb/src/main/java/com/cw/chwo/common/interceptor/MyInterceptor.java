package com.cw.chwo.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by handl on 2017/8/17.
 *
 * 自定义spring拦截器：继承HandlerInterceptorAdapter，
 *                  重写preHandle(请求发生前执行)方法，postHandle(请求完成后执行)方法
 *
 * 在springMvc配置文件中重写addInterceptors方法添加拦截器
 *
 *
 *
 */
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+new Long(endTime-startTime) + "ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
