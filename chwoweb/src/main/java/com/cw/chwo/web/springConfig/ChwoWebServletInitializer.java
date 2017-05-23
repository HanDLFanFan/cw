package com.cw.chwo.web.springConfig;

import com.cw.chwo.web.common.filter.MyFilter;
import com.cw.chwo.web.common.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;


/**
 * Created by handl on 2017/5/23.
 *
 *      按照 AbstractAnnotationConfigDispatcherServletInitializer 的定义，它会创建
 *          DispatcherServlet 和 ContextLoaderListener 。但是，如果你想注册其他的
 *          Servlet 、 Filter 或 Listener 的话，那该怎么办呢？
        基于 Java 的初始化器（ initializer ）的一个好处就在于我们可以定义任意数量的初始化器类。
            因此，如果我们想往 Web 容器中注册其他组件的话，只需创建一个新的初始化器就可以了。
            最简单的方式就是实现 Spring 的 WebApplicationInitializer 接口。
 *
 */
public class ChwoWebServletInitializer implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册servlet
        regServlet(servletContext);
        //注册Filter
//        regFilter(servletContext);
    }

    /**
     * 注册servlet
     * @param servletContext
     */
    private void regServlet(ServletContext servletContext){
        //注册servlet
        ServletRegistration.Dynamic myServlet = servletContext.
                addServlet("myServlet", MyServlet.class);
        //映射servlet
        myServlet.addMapping("/controller/**");
    }

    /**
     * 注册Filter
     * @param servletContext
     *
     *  如果只是注册 Filter ，并且该 Filter 只会映射到 DispatcherServlet 上的话，
     *  那么在 AbstractAnnotationConfigDispatcherServletInitializer 中还有一种快捷方式
     *  请查看ChwoWebServletLoadInitializer类的 getServletFilters() 方法
     */
    private void regFilter(ServletContext servletContext){
        //注册Filter
        FilterRegistration.Dynamic myFilter = servletContext
                .addFilter("myFilter", MyFilter.class);
        //映射Filter
        myFilter.addMappingForUrlPatterns(null,false,"/controller/**");
    }

    private void regListener(ServletContext servletContext){

    }

}
