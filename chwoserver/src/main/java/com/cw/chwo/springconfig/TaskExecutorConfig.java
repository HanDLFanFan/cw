package com.cw.chwo.springconfig;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by handl on 2017/8/17.
 *
 *
 * Spring通过任务执行器(TaskExecutor)来实现多线程和并发编程。使用ThreadPoolTaskExecutor
 * 可实现一个基于线程池的TaskExecutor。而实际开发中任务一般是非阻碍的，即异步的，所以我们
 * 要在配置类中通过@EnableAsync开启对异步任务的支持，并通过在实际执行的Bean的方法中使用@Async
 * 注解来声明是一个异步任务
 *
 *
 * 艾特Configuration：声明此类为一个配置类
 * 艾特EnableAsync：开启对异步任务的支持
 *
 * 配置类实现AsyncConfigurer接口并重写getAsyncExecutor()方法，并返回一个ThreadPoolTaskExecutor，
 * 这样我们就获得了一个基于线程池的TaskExecutor
 *
 *
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer{
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
