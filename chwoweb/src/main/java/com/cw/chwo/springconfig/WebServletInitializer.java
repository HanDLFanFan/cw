package com.cw.chwo.springconfig;

import com.cw.chwo.common.filter.MyFilter;
import com.cw.chwo.common.servlet.MyServlet;
import com.cw.chwo.common.listener.MyListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.*;
import java.util.HashMap;
import java.util.Map;


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
public class WebServletInitializer implements WebApplicationInitializer{

    private static Map<String,Class<?>> filter;


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //注册servlet
        regServlet(servletContext);
        //加载Filter
        initFilter();
        //注册Filter
        regFilter(servletContext);
        //注册Listen
        regListener(servletContext);
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


    private void initFilter(){
        filter = new HashMap();
        filter.put("encoding", CharacterEncodingFilter.class);
        filter.put("myFilter",MyFilter.class);
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
        if ( filter!= null && filter.size() > 0 ){
            for (String key : filter.keySet()) {
                FilterRegistration.Dynamic myFilter = servletContext
                        .addFilter(key, (Class<? extends Filter>) filter.get(key));
                //映射Filter
                myFilter.addMappingForUrlPatterns(null,false,"/*");
            }
        }
    }

    private void regListener(ServletContext servletContext){

        servletContext.addListener(MyListener.class);
    }

}
