package com.cw.chwo.springconfig;

import com.cw.chwo.service.UserService;
import com.cw.chwo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by handl on 2017/5/20.
 *
 *      SpringConfig:web容器的子配置，需要引用到聚合配置中(RootConfig，当然这仅仅是一种使用习惯)
 *          艾特Configuration：定义此文件为spring的java配置文件
 *          Environment ： 可以引用properties属性
 *          艾特Scope：创建Bean时的特性，单例，原型。。。。
 *
 */
@Configuration
public class ServerSpringContextConfig {
    @Autowired
    private Environment environment;
    @Value("${name}")
    private String name;

    @Bean
    public UserService userService(){
        System.out.println(environment.getProperty("db.name"));
        System.out.println(environment.getProperty("age"));
        System.out.println(environment.getProperty("email"));
        System.out.println(environment.getProperty("password"));

        return new UserServiceImpl();
    }

}
