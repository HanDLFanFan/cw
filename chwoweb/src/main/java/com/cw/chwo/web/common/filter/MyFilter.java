package com.cw.chwo.web.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by handl on 2017/5/23.
 *
 * Filter简介：
        Filter也称之为过滤器，它是Servlet技术中最实用的技术，Web开发人员通过Filter技术，
            对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，
            从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能。
        它主要用于对用户请求进行预处理，也可以对HttpServletResponse进行后处理。
        使用Filter的完整流程：Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成响应，
            最后Filter再对服务器响应进行后处理。

 Filter功能：
        在HttpServletRequest到达 Servlet 之前，拦截客户的HttpServletRequest 。根据需要检查HttpServletRequest，
            也可以修改HttpServletRequest 头和数据。
        在HttpServletResponse到达客户端之前，拦截HttpServletResponse 。根据需要检查HttpServletResponse，
            也可以修改HttpServletResponse头和数据。
 如何借助Filter实现拦截功能
        Filter接口中有一个doFilter方法，当开发人员编写好Filter，并配置对哪个web资源进行拦截后，Web服务器每次在调用web资源的service方法之前，都会先调用一下filter的doFilter方法，因此，在该方法内编写代码可达到如下目的
 *
 */
public class MyFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        FilterRegistration filterRegistration = servletContext.getFilterRegistration("myFilter");
        filterRegistration.setInitParameter("flag","Y");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);

        String flag = filterConfig.getServletContext().getFilterRegistration("myFilter").getInitParameter("flag");
        System.out.println("MyFilter flag = "+ flag);
        if(flag != null && "Y".equals(flag)){
            filterChain.doFilter(hrequest,wrapper);
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
