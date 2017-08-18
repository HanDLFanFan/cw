package com.cw.chwo.springconfig;

import com.cw.chwo.common.annotationmerge.WiselyConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by handl on 2017/8/17.
 *
 * 通过@EnableScheduling开启对计划任务的支持，
 * 然后在执行计划任务的方法上注解@Scheduled，声明这是一个计划任务
 * Spring通过Scheduled支持多种类型的计划任务，包含cron，fixDelay，fixRate等
 *
 */
@WiselyConfiguration
@EnableScheduling
public class TaskSchedulerConfig {
}
