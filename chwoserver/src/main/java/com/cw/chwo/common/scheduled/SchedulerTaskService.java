package com.cw.chwo.common.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by handl on 2017/8/17.
 *
 * fixedRate:上次任务执行完成后隔多少秒再次执行
 * corn:指定时间执行
 *
 * 艾特Scheduled：声明该方法是计划任务
 *
 */
@Service
public class SchedulerTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
    public void fixedRateTime(){
        System.out.println("fixedRate任务，每隔五秒执行一次----"+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 47 8 ? * *")
    public void cornTime(){
        System.out.println("corn任务，在指定时间执行----"+dateFormat.format(new Date()));
    }
}
