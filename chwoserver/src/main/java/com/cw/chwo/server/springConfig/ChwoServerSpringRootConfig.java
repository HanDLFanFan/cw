package com.cw.chwo.server.springConfig;

import com.cw.chwo.server.MarkerInterface;
import org.springframework.context.annotation.*;

/**
 * Created by handl on 2017/5/20.
 *
 * Spring的配置文件(此配置文件聚合其他的子配置文件，不做任何实际配置，在子配置文件中配置)
 *      艾特Configuration：定义此文件为spring的java配置文件
 *      艾特Import：引入其他子配置文件，多个资配置文件用逗号隔开
 *      艾特ComponentScan：启动注解扫描,
 *              此类使用的是basePackageClasses = MarkerInterface.class，扫描MarkerInterface类同目录和所有子目录的组件
 *              还可以使用basePackages，配置扫描的目录
 *              还可以设置包含和排除，（可在web项目里查看）
 *      艾特PropertySource：添加properties文件
 *      艾特EnableAspectJAutoProxy：启动AOP自动代理
 */
@Configuration
@Import(com.cw.chwo.server.springConfig.ChwoServerSpringContextConfig.class)
@ComponentScan(basePackageClasses = MarkerInterface.class)
@PropertySource("classpath:/system.properties")
@EnableAspectJAutoProxy
public class ChwoServerSpringRootConfig {
}
