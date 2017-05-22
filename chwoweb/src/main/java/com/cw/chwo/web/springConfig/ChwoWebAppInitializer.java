package com.cw.chwo.web.springConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
 *      也就是说这个类是来加载spring的容器环境
 *
 */
public class ChwoWebAppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
