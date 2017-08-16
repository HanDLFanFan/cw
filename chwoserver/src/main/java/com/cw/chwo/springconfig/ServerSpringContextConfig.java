package com.cw.chwo.springconfig;

import com.cw.chwo.service.UserService;
import com.cw.chwo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * Created by handl on 2017/5/20.
 *
 *      SpringConfig:web容器的子配置，需要引用到聚合配置中(RootConfig，当然这仅仅是一种使用习惯)
 *          艾特Configuration：定义此文件为spring的java配置文件
 *          Environment ： 可以引用properties属性
 *          艾特Scope：创建Bean时的特性，单例，原型。。。。
 *
 *
 *          ------------------------------------------
 *          spring-el表达式：
 *           1.注入普通字符串
 *           2.注入操作系统属性
 *           3.注入表达式运算结果
 *           4.注入其他bean的属性
 *           5.注入文件内容
 *           6.注入网址内容
 *           7.注入属性文件
 *
 *           pom文件添加commons-io可简化文件相关操作，本例使用commons-io将file
 *           转换成字符串：
 *
 */
@Configuration
public class ServerSpringContextConfig {

    /**
     *           1.注入普通字符串
     *           2.注入操作系统属性
     *           3.注入表达式运算结果
     *           4.注入其他bean的属性
     *           5.注入文件内容
     *           6.注入网址内容
     *           7.注入属性文件
     */

    //1.注入普通字符串
    @Value("注入普通字符串")
    private String normal;
    //2.注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;
    //3.注入表达式操作结果
    @Value("#{ T(java.lang.Math).random() * 100.00 }")
    private double randomNumber;
    //4.注入其他bean的属性
    @Value("#{outherClassPro.name}")
    private String outherClassPro;
    //5.注入文件内容
    @Value("classpath:/OutherClassPro.txt")
    private Resource filetext;
    //6.注入网址内容
    @Value("http://www.baidu.com")
    private Resource urltext;
    //7.注入属性文件
    @Value("${username}")
    private String name;

    //测试注入的属性
    public void testAutoired(){
        System.out.println("注入普通字符串，normal == "+normal);
        System.out.println("注入系统属性，osName == "+osName);
        System.out.println("注入运算结果，randomNumber == "+randomNumber);
        System.out.println("注入其他对象属性，outherClassPro == "+outherClassPro);
        System.out.println("注入文件内容，filetext == "+filetext);
        System.out.println("注入网页内容，urltext == "+urltext);
        System.out.println("注入配置文件属性，name == "+name);
    }

    /**
     * 以下是通过Environment来加载配置属性文件内容
     */
    @Autowired
    private Environment environment;

    @Bean
    public UserService userService(){
        System.out.println(environment.getProperty("username"));
        System.out.println(environment.getProperty("age"));
        System.out.println(environment.getProperty("email"));
        System.out.println(environment.getProperty("password"));
        return new UserServiceImpl();
    }

}
