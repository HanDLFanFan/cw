package com.cw.chwo.common.annotation;

import java.lang.annotation.*;

/**
 * Created by handl on 2017/7/21.
 *
 *      自定义注解，可通过Aop拦截注解，或者反射做其他操作
 *
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name() default "";
}
