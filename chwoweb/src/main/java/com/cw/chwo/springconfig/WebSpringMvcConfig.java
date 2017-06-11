package com.cw.chwo.springconfig;

import com.cw.chwo.module.User;
import com.cw.chwo.springconfig.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.cw.chwo.springconfig.viewresolver.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by handl on 2017/5/21.
 *
 *    ChwoWebSpringMvcConfig：SpringWeb容器环境的配置
 *          艾特Configuration：定义此文件为spring的java配置文件
 *          艾特EnableWebMvc：启用SpringMVC
 *          艾特ComponentScan：扫描controller包，通常这是controller组件的存放目录
 *          艾特Bean：配置一个bean(相当于在xml中配置一个<bean></bean>),会加入到spring容日中
 *          viewResolver():配置web试图解析器
 *          继承WebMvcConfigurerAdapter并覆盖 configureDefaultServletHandling： 要求DispatcherServlet 将对静态资源的请求转发到 Servlet 容器
                中默认的 Servlet 上，而不是使用 DispatcherServlet 本身来处理此类请求
 *          继承WebMvcConfigurerAdapter并覆盖configureContentNegotiation(ContentNegotiationConfigurer configurer): 设置多类型试图的默认方式，
 *          contentNegotiatingViewResolver(ContentNegotiationManager manager)：contentNegotiatingViewResolver添加ContentNegotiationManager
 *          jaxb2MarshallingXmlViewResolver()：配置xml视图解析类型
 *          jsonViewResolver()：配置json视图解析类型
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cw.chwo.controller")
public class WebSpringMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * 配置ContentNegotiatingViewResolver默认的处理类型，本例为html
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * 配置ContentNegotiatingViewResolver
     * @param manager
     * @return
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    /**
     * 配置xml解析类型
     * @return
     */
    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(User.class);
        marshaller.setCheckForXmlRootElement(true);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }

    /**
     * 配置json解析类型
     * @return
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        //配置可以解释jstl视图的class
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
