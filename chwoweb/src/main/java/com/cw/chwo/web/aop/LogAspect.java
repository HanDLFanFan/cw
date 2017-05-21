package com.cw.chwo.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/5/21.
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.cw.chwo.web.controller.UserHomeController.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void requestCheck(JoinPoint joinPoint){
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i <obj.length ; i++) {
            System.out.println("this is requestCheck,"+(String) obj[i]);
        }
    }

    @AfterReturning(pointcut = "pointcut()",returning="returnValue")
    public void responCheck(JoinPoint joinPoint,Object returnValue){
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i <obj.length ; i++) {
            System.out.println("this is responCheck,"+(String) obj[i]);
        }
        System.out.println("respon return is,"+returnValue);
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
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
    }
}
