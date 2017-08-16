package com.cw.chwo.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by handl on 2017/8/17.
 *
 * 监听流程如下：
 *      自定义事件继承ApplicationEvent
 *      定义时间监听器，实现ApplicationListener(处理监听到的消息)
 *      使用容器(消息发布器)发布事件
 *
 *
 * ApplicationEvent：为了bean与bean之间的消息通信提供支持，当一个bean处理完一个任务后，
 *                  希望让另一个bean知道并能做出相应的处理，这时需要让另外一个bean监听
 *                     当前bean所发送的事件
 *
 */
public class EventObject extends ApplicationEvent{

    private static final long seriaoVersionUID = 1L;
    private String msg;

    public EventObject(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
