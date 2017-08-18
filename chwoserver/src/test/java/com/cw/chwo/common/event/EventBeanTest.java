package com.cw.chwo.common.event;

import com.cw.chwo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by handl on 2017/8/17.
 */
public class EventBeanTest extends BaseTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Test
    public void publishMsg(){
        eventPublisher.publish("你好！我是发送器，我正在发送消息，你收到了吗！！");
    }

}
