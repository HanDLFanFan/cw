package com.cw.chwo.common.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/8/17.
 *
 *  监听流程如下：
 *      自定义事件继承ApplicationEvent
 *      定义时间监听器，实现ApplicationListener(处理监听到的消息)
 *      使用容器(消息发布器)发布事件
 *
 * 事件监听器，用以监听消息发布器发送的消息
 *
 *     实现  applicationListener<类型为监听的对象>
 *     重写  onApplicationEvent方法，处理接受到的消息
 *
 */
@Component
public class EventListener  implements ApplicationListener<EventObject> {
    @Override
    public void onApplicationEvent(EventObject event) {
        String msg = event.getMsg();

        System.out.println("EventListener接受到了EventPublisher发布的消息=="+msg);
    }
}
