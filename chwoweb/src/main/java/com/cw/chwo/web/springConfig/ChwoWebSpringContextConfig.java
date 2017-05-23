package com.cw.chwo.web.springConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.io.IOException;

/**
 * Created by handl on 2017/5/20.
 *
 *  ChwoWebSpringContextConfig:web容器的子配置，需要引用到聚合配置中(RootConfig，当然这仅仅是一种使用习惯)
 *          艾特Configuration：定义此文件为spring的java配置文件
 *          Environment ： 可以引用properties属性，（参考server项目）
 */
@Configuration
public class ChwoWebSpringContextConfig {
    @Autowired
    private Environment environment;

    /**
     * 注册文件上传组件
     * @return
     * @throws IOException
     */
    /*@Bean
    public MultipartResolver multipartResolver()throws IOException{
        return new StandardServletMultipartResolver();
    }*/

}
