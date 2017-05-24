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
     *
     * 如果在编写控制器方法的时候，通过 Part 参数的形式接受文件上传，那么就没有必要配置 MultipartResolver 了。只有使
    用 MultipartFile 的时候，我们才需要 MultipartResolver
     */
    /*@Bean
    public MultipartResolver multipartResolver()throws IOException{
        return new StandardServletMultipartResolver();
    }*/

}
