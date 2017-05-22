package com.cw.chwo.web.springConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by handl on 2017/5/20.
 *
 *  SpringConfig:web容器的子配置，需要引用到聚合配置中(RootConfig，当然这仅仅是一种使用习惯)
 *          艾特Configuration：定义此文件为spring的java配置文件
 *          Environment ： 可以引用properties属性，（参考server项目）
 */
@Configuration
public class WebSpringConfig {
    @Autowired
    private Environment environment;

}
