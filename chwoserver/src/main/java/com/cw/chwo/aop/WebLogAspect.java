package com.cw.chwo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/5/21.
 *
 * AOP切面编程配置：
 *      艾特Aspect：启用AOP注解，声明这是一个切面
 *      艾特Component： 设置此类为spring组件
 *      艾特Pointcut(切点) ：配置作用的连接点，所作用的方法只做个锚点，然后就可在通知方法注解中使用，而无需配置多次。
 *      艾特Before("@Pointcut标注的方法(切点)")
 *      艾特Around("@Pointcut标注的方法(切点)")
 *      ProceedingJoinPoint：只能在@Around中使用，可以获取参数或者返回值
 *      JoinPoint ：检测请求参数等等
 *
 */
@Aspect
@Component
public class WebLogAspect {

    //注解拦截(自定义注解),在需要拦截的类上注解
    @Pointcut("@annotation(com.cw.chwo.common.annotation.Action)")
    //方法规则拦截
//    @Pointcut("execution(* com.cw.chwo.service.impl.UserServiceImpl.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void requestCheck(JoinPoint joinPoint){
        System.out.println("aop----requestCheck");
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i <obj.length ; i++) {
            System.out.println("this is requestCheck,"+(String) obj[i]);
        }
        System.out.println("aop----requestCheck");
    }

    /*@AfterReturning(pointcut = "pointcut()",returning="returnValue")
    public void responCheck(JoinPoint joinPoint,Object returnValue){
        System.out.println("aop----responCheck");
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i <obj.length ; i++) {
            System.out.println("this is responCheck,"+(String) obj[i]);
        }
        System.out.println("respon return is,"+returnValue);
    }*/

    /*@Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("aop----around");
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i <obj.length ; i++) {
            obj[i] = obj[i]+",around";
            System.out.println("this is around,"+(String) obj[i]);
        }

        try {
            Object returnValue = joinPoint.proceed(obj);
            System.out.println("this is around respon "+(String)returnValue);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
}
