package com.cw.chwo.common.annotationmerge;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by handl on 2017/8/17.
 *
 * 元注解：即可以注解在别的注解上的注解
 * 组合注解：被注解的注解就是组合注解，例如@Configuration注解就是一个组合了@Component的组合注解
 *          组合注解具备注解其上的元注解功能
 *
 * 此案列中@Configuration和@ComponentScan就是元注解
 * WiselyConfiguration注解就是组合注解
 *
 * 一定要覆盖在元注解中使用到的方法，注意：覆盖的方法上的注解不需要覆盖
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {};

    Class<?>[] basePackageClasses() default {};

    String[] basePackages() default {};

    ComponentScan.Filter[] excludeFilters() default {};
}
