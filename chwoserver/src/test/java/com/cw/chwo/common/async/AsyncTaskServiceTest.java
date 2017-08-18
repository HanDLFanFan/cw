package com.cw.chwo.common.async;

import com.cw.chwo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;

/**
 * Created by handl on 2017/8/17.
 */
public class AsyncTaskServiceTest extends BaseTest {

    @Autowired
    private AsyncTaskService asyncTaskService;

    //任务(阻塞)队列满了抛异常，抓捕异常作特殊处理
    @Test
    public void asyncTest(){
        for (int i = 0; i < 285; i++) {
            try{
                asyncTaskService.asyncTask_1(i);
            }catch (TaskRejectedException exception){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                asyncTaskService.asyncTask_1(i);
            }

            try{
                asyncTaskService.asyncTask_2(i);
            }catch (TaskRejectedException exception){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                asyncTaskService.asyncTask_2(i);
            }
        }
    }
}
