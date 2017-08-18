package com.cw.chwo.common.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by handl on 2017/8/17.
 *
 * 任务执行类
 *
 * 通过@Async注解表明该方法是个异步方法，如果注解在类级别上，则表明该类所有的方法
 * 都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
 *
 *
 * 测试类运行------
 */
@Service
public class AsyncTaskService {

    @Async
    public void asyncTask_1(Integer i){
        System.out.println("异步任务asyncTask_111111----"+i);
    }

    @Async
    public void asyncTask_2(Integer i){
        System.out.println("异步任务asyncTask_222222----"+i);
    }

}
