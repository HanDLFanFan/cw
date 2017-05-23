package com.cw.chwo.web.springConfig;

import com.cw.chwo.web.common.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by handl on 2017/5/21.
 *
 * 此类用来配置并加载spring容器，springWeb容器环境和配置DispatcherServlet请求路径映射
 *
 *   要点：
 *          在 Servlet 3.0 环境中，容器会在类路径中查找实现 javax.servlet.ServletContainerInitializer 接口的类，
 *      如果能发现的话，就会用它来配置 Servlet 容器。Spring 提供了这个接口的实现，名为SpringServletContainerInitializer，
 *      这个类反过来又会查找实现 WebApplicationInitializer 的类并将配置的任务交给它们来完成。
 *      Spring 3.2 引入了一个便利的 WebApplicationInitializer 基础实现，也就是 AbstractAnnotationConfigDispatcherServletInitializer。
 *      因为我们的 ChwoWebAppInitializer 扩展了 AbstractAnnotationConfig DispatcherServlet-Initializer （同时也就实现了 WebApplicationInitializer ），
 *      因此当部署到 Servlet 3.0 容器中的时候，容器会自动发现它，并用它来配置 Servlet 上下文
 *
 *      getRootConfigClasses() ：用来加载Spring容器环境
 *              返回的带有 @Configuration 注解的类将会用来配置 ContextLoaderListener 创建的应用上下文中的 bean
 *      getServletConfigClasses：用来加载SpringWeb容器环境
 *              返回的带有 @Configuration 注解的类将会用来定义 DispatcherServlet 应用上下文中的 bean
 *      getServletMappings ： 配置DispatcherServlet请求路径映射
 *
 *       customizeRegistration ：在 AbstractAnnotation-ConfigDispatcherServletInitializer 将
 *              DispatcherServlet 注册到 Servlet 容器中之后，就会调用 customizeRegistration() ，
 *              并将 Servlet 注册后得到的 Registration.Dynamic 传递进来。
 *              通过重载 customizeRegistration() 方法，我们可以对 DispatcherServlet 进行额外的配置
 *
 *      也就是说这个类是来加载spring的容器环境
 *
 */
public class ChwoWebServletLoadInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ChwoWebSpringRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ChwoWebSpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 重载 customizeRegistration() 方法，我们可以对 DispatcherServlet 进行额外的配置
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //文件上传属性配置
        regMultipartConfig(registration);
    }

    /**
     * 文件上传属性配置
     * @param registration
     */
    private void regMultipartConfig(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(new MultipartConfigElement("D:/files/",
                2100000,4200000,0));
    }

    /**
     * 注册Filter(只有和DispatcherServlet相同映射时才可以这样配置，
     *      否则请查看ChwoWebServletInitializer类的regFilter方法)
     *
     *  如果只是注册 Filter ，并且该 Filter 只会映射到 DispatcherServlet 上的话，
     *  那么在 AbstractAnnotationConfigDispatcherServletInitializer 中还有一种快捷方式
     *  请查看ChwoWebServletLoadInitializer类的 getServletFilters() 方法
     */
    @Override
    protected Filter[] getServletFilters() {
       return new Filter[]{ new MyFilter() };
    }
}
