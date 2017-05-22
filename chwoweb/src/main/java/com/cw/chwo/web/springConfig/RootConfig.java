package com.cw.chwo.web.springConfig;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by handl on 2017/5/20.
 *
 * Spring的配置文件(此配置文件聚合其他的子配置文件，不做任何实际配置，在子配置文件中配置)
 *      艾特Configuration：定义此文件为spring的java配置文件
 *      艾特Import：引入其他子配置文件，多个资配置文件用逗号隔开
 *      艾特ComponentScan：启动注解扫描(此类中过滤掉mvc[controller]的扫描，mvc[controller]的扫描在SpringWebConfig配置文件)
 *      艾特EnableAspectJAutoProxy：启动AOP自动代理
 */
@Configuration
@Import({SpringConfig.class, com.cw.chwo.server.springConfig.RootConfig.class})
@ComponentScan(basePackages = {"com.cw.chwo.web"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
@EnableAspectJAutoProxy
public class RootConfig {
}
