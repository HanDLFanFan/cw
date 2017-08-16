package com.cw.chwo.common.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/8/17.
 *
 * 监听流程如下：
 *      自定义事件继承ApplicationEvent
 *      定义时间监听器，实现ApplicationListener(处理监听到的消息)
 *      使用容器(消息发布器)发布事件
 *
 *
 * 消息发布器，注入ApplicationContext，用以发布消息
 *
 *
 */
@Component
public class EventPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        applicationContext.publishEvent(new EventObject(this,msg));
    }
}
