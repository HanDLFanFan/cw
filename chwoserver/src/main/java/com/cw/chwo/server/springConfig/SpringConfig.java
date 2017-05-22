package com.cw.chwo.server.springConfig;

import com.cw.chwo.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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
public class SpringConfig {
    @Autowired
    private Environment environment;
    @Value("${name}")
    private String name;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public User user(){
        User user = new User();
        user.setName(name);
        user.setAge(environment.getProperty("age",Integer.class));
        return user;
    }

}
