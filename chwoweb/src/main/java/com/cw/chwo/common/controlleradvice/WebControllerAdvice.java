package com.cw.chwo.common.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by handl on 2017/5/24.
 *
 *      艾特ExceptionHandler 注解标注的方法；
        艾特InitBinder 注解标注的方法；
        艾特ModelAttribute 注解标注的方法。

        在带有 艾特ControllerAdvice 注解的类中，以上所述的这些方法会运用到整个应用程序所有控制器中带有
            艾特RequestMapping 注解的方法上。

        艾特ControllerAdvice 注解本身已经使用了艾特Component ，
            因此艾特ControllerAdvice 注解所标注的类将会自动被组件扫描获取到，
            就像带有艾特Component 注解的类一样。

        艾特ControllerAdvice 最为实用的一个场景就是将所有的艾特ExceptionHandler 方法收集到一个类中，
            这样所有控制器的异常就能在一个地方进行一致的处理。
 *
 */
@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception exception, WebRequest request){

        return "error";
    }
}
