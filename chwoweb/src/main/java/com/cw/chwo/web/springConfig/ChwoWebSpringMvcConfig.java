package com.cw.chwo.web.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cw.chwo.web.controller")
public class ChwoWebSpringMvcConfig extends WebMvcConfigurerAdapter{

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
